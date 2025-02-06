package progettino.dnd.projectDnd.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.CampaignDto;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.*;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.BagRepository;
import progettino.dnd.projectDnd.model.repositories.CampaignRepository;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.DiaryRepository;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/characters")
@Validated
public class CharacterPgController {
    private CharacterPgService characterPgService;
    private BagRepository bagRepository;
    private DiaryRepository diaryRepository;
    private CampaignRepository campaignRepository;
    private CharacterPgRepository characterPgRepository;
//
//


    @Autowired
    public CharacterPgController(CharacterPgService characterPgService, BagRepository bagRepository, DiaryRepository diaryRepository, CampaignRepository campaignRepository, CharacterPgRepository characterPgRepository) {
        this.characterPgService = characterPgService;
        this.bagRepository = bagRepository;
        this.diaryRepository = diaryRepository;
        this.campaignRepository = campaignRepository;
        this.characterPgRepository = characterPgRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCharacter() {
            List<CharacterPg> c = characterPgService.getAllCharacterPgs();
            List<CharacterPgDto> cDto = c.stream().map(CharacterPgDto::fromEntity).toList();
            return ResponseEntity.ok(cDto);
    }


    @PostMapping
    public ResponseEntity<CharacterPg> createCharacterPg(
            @RequestBody CharacterPg characterPg,
            @AuthenticationPrincipal User user,  // Ottieni l'utente connesso tramite authentication
            @RequestParam long campaignId) {  // ID campagna passato come parametro query


            // Salva prima il characterPg per garantire che sia persistito
            characterPg.setUser(user);  // Associa l'utente
            Optional<Campaign> campaign = campaignRepository.findById(campaignId);  // Trova la campagna
            if (campaign.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            characterPg.setCampaign(campaign.get());

            // Salva il CharacterPg prima di fare riferimento a Bag e Diary
            characterPg = characterPgRepository.save(characterPg);

            // Ora crea e associa Bag e Diary dopo aver salvato CharacterPg
            Bag bag = new Bag();
            bag.setPg(characterPg);  // Associa il characterPg al bag
            bagRepository.save(bag);  // Salva il Bag nel database
            characterPg.setBag(bag);  // Associa il bag salvato al characterPg

            Diary diary = new Diary();
            diary.setPg(characterPg);  // Associa il characterPg al diario
            diaryRepository.save(diary);  // Salva il Diary nel database
            characterPg.setDiary(diary);  // Associa il diary salvato al characterPg

            // Restituisci il personaggio creato
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


}
