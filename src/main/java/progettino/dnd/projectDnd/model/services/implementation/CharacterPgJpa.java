package progettino.dnd.projectDnd.model.services.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.dtos.StaticDto;
import progettino.dnd.projectDnd.model.entities.*;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.*;
import progettino.dnd.projectDnd.model.repositories.security.UserRepository;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CharacterPgJpa implements CharacterPgService {
    private CharacterPgRepository characterPgRepository;
    private UserDetailRepository userDetailRepository;
    private SlotRepository slotRepository;
    private BagRepository bagRepository;
    private DiaryRepository diaryRepository;
    private AbilityPgRepository abilityPgRepository;
    private StaticRepository staticRepository;
    private TiriSalvezzaRepository tiriSalvezzaRepository;
    private CampaignRepository campaignRepository;
    private TalentRepository talentRepository;
    private TraitRepository traitRepository;
    private AbilityRepository abilityRepository;

    @Autowired
    public CharacterPgJpa(CharacterPgRepository characterPgRepository, UserDetailRepository userDetailRepository, SlotRepository slotRepository, BagRepository bagRepository, DiaryRepository diaryRepository, AbilityPgRepository abilityPgRepository, StaticRepository staticRepository, TiriSalvezzaRepository tiriSalvezzaRepository, CampaignRepository campaignRepository, TalentRepository talentRepository, TraitRepository traitRepository, AbilityRepository abilityRepository) {
        this.characterPgRepository = characterPgRepository;
        this.userDetailRepository = userDetailRepository;
        this.slotRepository = slotRepository;
        this.bagRepository = bagRepository;
        this.diaryRepository = diaryRepository;
        this.abilityPgRepository = abilityPgRepository;
        this.staticRepository = staticRepository;
        this.tiriSalvezzaRepository = tiriSalvezzaRepository;
        this.campaignRepository = campaignRepository;
        this.talentRepository = talentRepository;
        this.traitRepository = traitRepository;
        this.abilityRepository = abilityRepository;
    }

    @Override
    public CharacterPg createCharacterPg(CharacterPg characterPg, long userId, long campaignId) throws EntityNotFoundException {
        // 1. Recupero l'utente associato tramite userId
        Optional<User> optionalUser = userDetailRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("Utente con id: " + userId + " non trovato");
        }
        User user = optionalUser.get();

        // 2. Associo l'utente al CharacterPg
        characterPg.setUser(user);

        // 3. Gestisco le relazioni con altre entità
        // 3.1. Slots: inizializzati vuoti
//        if (characterPg.getSlots() == null) {
//            characterPg.setSlots(new ArrayList<>());
//        } else {
//            List<Slot> slots = new ArrayList<>();
//            for (Slot slot : characterPg.getSlots()) {
//                Optional<Slot> optionalSlot = slotRepository.findById(slot.getId());
//                if (optionalSlot.isEmpty()) {
//                    throw new EntityNotFoundException("Slot con id: " + slot.getId() + " non trovato");
//                }
//                slots.add(optionalSlot.get());
//            }
//            characterPg.setSlots(slots);
//        }

        // 3.2. Bag: Se non c'è, creo un nuovo zaino vuoto
        if (characterPg.getBag() == null) {
            Bag newBag = new Bag(); // Crea un nuovo oggetto vuoto Bag
            characterPg.setBag(newBag); // Associa il nuovo zaino al CharacterPg
        } else {
            Optional<Bag> optionalBag = bagRepository.findById(characterPg.getBag().getId());
            if (optionalBag.isEmpty()) {
                throw new EntityNotFoundException("Bag con id: " + characterPg.getBag().getId() + " non trovato");
            }
            characterPg.setBag(optionalBag.get());
        }

        // 3.3. Diary: Se non c'è, creo un nuovo diario vuoto
        if (characterPg.getDiary() == null) {
            Diary newDiary = new Diary(); // Crea un nuovo oggetto vuoto Diary
            characterPg.setDiary(newDiary); // Associa il nuovo diario al CharacterPg
        } else {
            Optional<Diary> optionalDiary = diaryRepository.findById(characterPg.getDiary().getId());
            if (optionalDiary.isEmpty()) {
                throw new EntityNotFoundException("Diary con id: " + characterPg.getDiary().getId() + " non trovato");
            }
            characterPg.setDiary(optionalDiary.get());
        }

        // 3.4. AbilityPg
        if (characterPg.getAbilityPgs() != null) {
            List<AbilityPg> abilityPgs = new ArrayList<>();
            for (AbilityPg abilityPg : characterPg.getAbilityPgs()) {
                Optional<Ability> optionalAbility = abilityRepository.findById(abilityPg.getAbility().getId());  // Troviamo l'abilità tramite ID
                if (optionalAbility.isEmpty()) {
                    throw new EntityNotFoundException("Ability con id: " + abilityPg.getAbility().getId() + " non trovata");
                }
                Ability ability = optionalAbility.get();
                AbilityPg newAbilityPg = new AbilityPg();
                newAbilityPg.setAbility(ability);
                newAbilityPg.setCompetence(abilityPg.isCompetence());
                newAbilityPg.setPoint(abilityPg.getPoint());
                newAbilityPg.setPg(characterPg);  // Associa l'AbilityPg al personaggio

                abilityPgs.add(newAbilityPg);
            }
            characterPg.setAbilityPgs(abilityPgs);
        }

        // 3.5. StaticList
        if (characterPg.getStaticList() != null) {
            List<Static> staticList = new ArrayList<>();
            for (Static aStatic : characterPg.getStaticList()) {
                // Troviamo l'oggetto CharacterPg tramite l'ID del personaggio (pgId)
               // Optional<CharacterPg> optionalPg = characterPgRepository.findById(aStatic.getPgId());
//                if (optionalPg.isEmpty()) {
//                    throw new EntityNotFoundException("Personaggio con id: " + aStatic.getPgId() + " non trovato");
//                }
                //CharacterPg pg = optionalPg.get();

                // Creiamo una nuova entità Static a partire dal DTO
                Static staticEntity = new Static();
                staticEntity.setId(aStatic.getId());  // Impostiamo l'ID (se esiste già nel DB, altrimenti generiamo un nuovo ID)
                staticEntity.setType(aStatic.getType());  // Impostiamo il tipo
                staticEntity.setPoint(aStatic.getPoint());  // Impostiamo il punto
                staticEntity.setModificatore(aStatic.getModificatore());  // Impostiamo il modificatore
                staticEntity.setPg(characterPg);  // Associare il personaggio

                staticList.add(staticEntity);
            }
            // Impostiamo la lista aggiornata di Static
            characterPg.setStaticList(staticList);
        }

        // 3.6. TiriSalvezza
        if (characterPg.getTiriSalvezza() != null) {
            List<TiriSalvezza> tiriSalvezza = new ArrayList<>();
            for (TiriSalvezza tiriSalvezzaEntity : characterPg.getTiriSalvezza()) {
                Optional<TiriSalvezza> optionalTiriSalvezza = tiriSalvezzaRepository.findById(tiriSalvezzaEntity.getId());
                if (optionalTiriSalvezza.isEmpty()) {
                    throw new EntityNotFoundException("TiriSalvezza con id: " + tiriSalvezzaEntity.getId() + " non trovato");
                }
                tiriSalvezza.add(optionalTiriSalvezza.get());
            }
            characterPg.setTiriSalvezza(tiriSalvezza);
        }

        // 3.7. Campagna: prendo il campagnaId passato come argomento
        if (campaignId == 0) {  // Usa 0 come valore di default per long
            throw new EntityNotFoundException("ID campagna non fornito");
        }

        Optional<Campaign> optionalCampaign = campaignRepository.findById(campaignId);
        if (optionalCampaign.isEmpty()) {
            throw new EntityNotFoundException("Campaign con id: " + campaignId + " non trovato");
        }
        characterPg.setCampaign(optionalCampaign.get());


        // 3.8. Talents: inizializzati vuoti
        if (characterPg.getTalents() == null) {
            characterPg.setTalents(new ArrayList<>());
        } else {
            List<Talent> talents = new ArrayList<>();
            for (Talent talent : characterPg.getTalents()) {
                Optional<Talent> optionalTalent = talentRepository.findById(talent.getId());
                if (optionalTalent.isEmpty()) {
                    throw new EntityNotFoundException("Talent con id: " + talent.getId() + " non trovato");
                }
                talents.add(optionalTalent.get());
            }
            characterPg.setTalents(talents);
        }

        // 3.9. Traits: inizializzati vuoti
        if (characterPg.getTraits() == null) {
            characterPg.setTraits(new ArrayList<>());
        } else {
            List<Trait> traits = new ArrayList<>();
            for (Trait trait : characterPg.getTraits()) {
                Optional<Trait> optionalTrait = traitRepository.findById(trait.getId());
                if (optionalTrait.isEmpty()) {
                    throw new EntityNotFoundException("Trait con id: " + trait.getId() + " non trovato");
                }
                traits.add(optionalTrait.get());
            }
            characterPg.setTraits(traits);
        }

        // 4. Salvo il CharacterPg nel database
        return characterPgRepository.save(characterPg);
    }


}
