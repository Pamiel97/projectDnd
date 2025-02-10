package progettino.dnd.projectDnd.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.*;
import progettino.dnd.projectDnd.model.entities.*;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.*;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@RestController
@RequestMapping("/api/characters")
@Validated
public class CharacterPgController {
    private CharacterPgService characterPgService;
    private BagRepository bagRepository;
    private DiaryRepository diaryRepository;
    private CampaignRepository campaignRepository;
    private CharacterPgRepository characterPgRepository;
    private SlotRepository slotRepository;
    private AbilityRepository abilityRepository;
    private AbilityPgRepository abilityPgRepository;
    private TiriSalvezzaRepository tiriSalvezzaRepository;
    private StaticRepository staticRepository;
//
//


    @Autowired
    public CharacterPgController(CharacterPgService characterPgService, BagRepository bagRepository, DiaryRepository diaryRepository, CampaignRepository campaignRepository, CharacterPgRepository characterPgRepository, SlotRepository slotRepository, AbilityRepository abilityRepository, AbilityPgRepository abilityPgRepository, TiriSalvezzaRepository tiriSalvezzaRepository, StaticRepository staticRepository) {
        this.characterPgService = characterPgService;
        this.bagRepository = bagRepository;
        this.diaryRepository = diaryRepository;
        this.campaignRepository = campaignRepository;
        this.characterPgRepository = characterPgRepository;
        this.slotRepository = slotRepository;
        this.abilityRepository = abilityRepository;
        this.abilityPgRepository = abilityPgRepository;
        this.tiriSalvezzaRepository = tiriSalvezzaRepository;
        this.staticRepository = staticRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCharacter() {
            List<CharacterPg> c = characterPgService.getAllCharacterPgs();
            List<CharacterPgDto> cDto = c.stream().map(CharacterPgDto::fromEntity).toList();
            return ResponseEntity.ok(cDto);
    }


    @PostMapping
    public ResponseEntity<CharacterPg> createCharacterPg(
            @RequestBody CharacterPgDto characterPgDto,
            @AuthenticationPrincipal User user,  // Ottieni l'utente connesso tramite authentication
            @RequestParam long campaignId) {  // ID campagna passato come parametro query


            CharacterPg characterPg = characterPgDto.toEntity();


            characterPg.setUser(user);
            Optional<Campaign> campaign = campaignRepository.findById(campaignId);  // Trova la campagna
            if (campaign.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            characterPg.setCampaign(campaign.get());

            // Salva il CharacterPg prima di fare riferimento a Bag e Diary
            characterPg = characterPgRepository.save(characterPg);

            // Ora crea e associa Bag e Diary dopo aver salvato CharacterPg
            Bag bag = new Bag();
            bag.setPg(characterPg);
            bagRepository.save(bag);
            characterPg.setBag(bag);

            Diary diary = new Diary();
            diary.setPg(characterPg);
            diaryRepository.save(diary);
            characterPg.setDiary(diary);

            final CharacterPg savedCharacterPg = characterPg; // Assicura l'immutabilità nella lambda

            List<Slot> listSlot = IntStream.rangeClosed(1, 10)
                .mapToObj(level -> {
                    Slot slot = new Slot();
                    slot.setLevelSlot(level);
                    slot.setPg(savedCharacterPg);
                    return slot;
                })
                .toList();
            slotRepository.saveAll(listSlot);  // Salvataggio batch
            characterPg.setSlots(listSlot);


             List<AbilityPg> listAbility = LongStream.rangeClosed(1, 18)
                .mapToObj(id -> {
                    AbilityPg ab = new AbilityPg();
                    ab.setAbility(abilityRepository.findById(id).orElseThrow());
                    ab.setPg(savedCharacterPg);
                    return ab;
                })
                .toList();
                abilityPgRepository.saveAll(listAbility);  // Salvataggio batch
                characterPg.setAbilityPgs(listAbility);

                List<TiriSalvezza> tsList = new ArrayList<>();
                List<Static> staticList = new ArrayList<>();
                List<Type> types = List.of(
                   Type.FORZA, Type.DESTREZZA, Type.COSTITUZIONE,
                   Type.INTELLIGENZA, Type.SAGGEZZA, Type.CARISMA
                );

        for (Type type : types) {
            TiriSalvezza ts = new TiriSalvezza();
            ts.setType(type);
            ts.setPg(characterPg);
            tiriSalvezzaRepository.save(ts);
            tsList.add(ts);

            Static statics = new Static();
            statics.setType(type);
            statics.setPg(characterPg);
            staticRepository.save(statics);
            staticList.add(statics);
        }
        characterPg.setTiriSalvezza(tsList);
        characterPg.setStaticList(staticList);
        return new ResponseEntity<>(characterPg, HttpStatus.CREATED);  // Rispondi con il personaggio creato
    }


    @PostMapping("/addTalent")
    public ResponseEntity<?> addTalentToPg(@RequestParam Long pgId, @RequestParam Long talentId) {
        CharacterPg updatedPg = null;
        try {
            updatedPg = characterPgService.addTalentToPg(pgId, talentId);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Save!");
    }


    @PostMapping("/addTrait")
    public ResponseEntity<?> addTraitToPg(@RequestParam Long pgId, @RequestParam Long traitId) {
        CharacterPg updatedPg = null;
        try {
            updatedPg = characterPgService.addTraitToPg(pgId, traitId);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Save!");
    }

    @GetMapping("/talents")
    public ResponseEntity<List<TalentDto>> getAllTalents() {
        List<TalentDto> talentDtos = characterPgService.getAllTalents();
        return new ResponseEntity<>(talentDtos, HttpStatus.OK);
    }

    @GetMapping("/traits")
    public ResponseEntity<List<TraitDto>> getAllTraits() {
        List<TraitDto> traitDtos = characterPgService.getAllTraits();
        return new ResponseEntity<>(traitDtos, HttpStatus.OK);
    }

    @GetMapping("/diary/{pgId}")
    public ResponseEntity<DiaryDto> getDiaryByCharacter(@PathVariable Long pgId) {
        DiaryDto diaryDto = characterPgService.getDiaryByCharacter(pgId);
        if (diaryDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(diaryDto, HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<CharacterPg> updateCharacterPg(
            @PathVariable long id,
            @RequestBody CharacterPgDto characterPgDto) {

        try {
            // Converte il DTO nell'entità e chiama il service
            CharacterPg characterPg = characterPgDto.toEntity();
            CharacterPg updatedCharacterPg = characterPgService.updateCharacterPg(id, characterPg);
            return ResponseEntity.ok(updatedCharacterPg);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<CharacterPgDto>> getCharacterPgByCampaignId(@PathVariable long campaignId) {
        try {
            // Chiama il servizio per ottenere la lista di DTO
            List<CharacterPgDto> characterPgDtos = characterPgService.getCharacterPgByCampaignId(campaignId);
            return ResponseEntity.ok(characterPgDtos); // Restituisce la lista di DTO con status 200 OK
        } catch (EntityNotFoundException e) {
            // Restituisce un errore 404 se non ci sono personaggi per quella campagna
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



}
