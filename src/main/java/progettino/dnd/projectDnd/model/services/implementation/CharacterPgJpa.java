package progettino.dnd.projectDnd.model.services.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.*;
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

//    @Override
//    public CharacterPg createCharacterPg(CharacterPg characterPg, long userId, long campaignId) throws EntityNotFoundException {
//        // 1. Recupero l'utente associato tramite userId
//        Optional<User> optionalUser = userDetailRepository.findById(userId);
//        if (optionalUser.isEmpty()) {
//            throw new EntityNotFoundException("Utente con id: " + userId + " non trovato");
//        }
//        User user = optionalUser.get();
//
//        // 2. Associo l'utente al CharacterPg
//        characterPg.setUser(user);
//
//        // 3. Gestisco le relazioni con altre entità
//        // 3.1. Slots: inizializzati vuoti
////        if (characterPg.getSlots() == null) {
////            characterPg.setSlots(new ArrayList<>());
////        } else {
////            List<Slot> slots = new ArrayList<>();
////            for (Slot slot : characterPg.getSlots()) {
////                Optional<Slot> optionalSlot = slotRepository.findById(slot.getId());
////                if (optionalSlot.isEmpty()) {
////                    throw new EntityNotFoundException("Slot con id: " + slot.getId() + " non trovato");
////                }
////                slots.add(optionalSlot.get());
////            }
////            characterPg.setSlots(slots);
////        }
//
//        // 3.2. Bag: Se non c'è, creo un nuovo zaino vuoto
//        if (characterPg.getBag() == null) {
//            Bag newBag = new Bag(); // Crea un nuovo oggetto vuoto Bag
//            characterPg.setBag(newBag); // Associa il nuovo zaino al CharacterPg
//        } else {
//            Optional<Bag> optionalBag = bagRepository.findById(characterPg.getBag().getId());
//            if (optionalBag.isEmpty()) {
//                throw new EntityNotFoundException("Bag con id: " + characterPg.getBag().getId() + " non trovato");
//            }
//            characterPg.setBag(optionalBag.get());
//        }
//
//        // 3.3. Diary: Se non c'è, creo un nuovo diario vuoto
//        if (characterPg.getDiary() == null) {
//            Diary newDiary = new Diary(); // Crea un nuovo oggetto vuoto Diary
//            characterPg.setDiary(newDiary); // Associa il nuovo diario al CharacterPg
//        } else {
//            Optional<Diary> optionalDiary = diaryRepository.findById(characterPg.getDiary().getId());
//            if (optionalDiary.isEmpty()) {
//                throw new EntityNotFoundException("Diary con id: " + characterPg.getDiary().getId() + " non trovato");
//            }
//            characterPg.setDiary(optionalDiary.get());
//        }
//
//        // 3.4. AbilityPg
//        if (characterPg.getAbilityPgs() != null) {
//            List<AbilityPg> abilityPgs = new ArrayList<>();
//            for (AbilityPg abilityPg : characterPg.getAbilityPgs()) {
//                Optional<Ability> optionalAbility = abilityRepository.findById(abilityPg.getAbility().getId());  // Troviamo l'abilità tramite ID
//                if (optionalAbility.isEmpty()) {
//                    throw new EntityNotFoundException("Ability con id: " + abilityPg.getAbility().getId() + " non trovata");
//                }
//                Ability ability = optionalAbility.get();
//                AbilityPg newAbilityPg = new AbilityPg();
//                newAbilityPg.setAbility(ability);
//                newAbilityPg.setCompetence(abilityPg.isCompetence());
//                newAbilityPg.setPoint(abilityPg.getPoint());
//                newAbilityPg.setPg(characterPg);  // Associa l'AbilityPg al personaggio
//
//                abilityPgs.add(newAbilityPg);
//            }
//            characterPg.setAbilityPgs(abilityPgs);
//        }
//
//        // 3.5. StaticList
//        if (characterPg.getStaticList() != null) {
//            List<Static> staticList = new ArrayList<>();
//            for (Static aStatic : characterPg.getStaticList()) {
//                // Troviamo l'oggetto CharacterPg tramite l'ID del personaggio (pgId)
//               // Optional<CharacterPg> optionalPg = characterPgRepository.findById(aStatic.getPgId());
////                if (optionalPg.isEmpty()) {
////                    throw new EntityNotFoundException("Personaggio con id: " + aStatic.getPgId() + " non trovato");
////                }
//                //CharacterPg pg = optionalPg.get();
//
//                // Creiamo una nuova entità Static a partire dal DTO
//                Static staticEntity = new Static();
//                staticEntity.setId(aStatic.getId());  // Impostiamo l'ID (se esiste già nel DB, altrimenti generiamo un nuovo ID)
//                staticEntity.setType(aStatic.getType());  // Impostiamo il tipo
//                staticEntity.setPoint(aStatic.getPoint());  // Impostiamo il punto
//                staticEntity.setModificatore(aStatic.getModificatore());  // Impostiamo il modificatore
//                staticEntity.setPg(characterPg);  // Associare il personaggio
//
//                staticList.add(staticEntity);
//            }
//            // Impostiamo la lista aggiornata di Static
//            characterPg.setStaticList(staticList);
//        }
//
//        // 3.6. TiriSalvezza
//        if (characterPg.getTiriSalvezza() != null) {
//            List<TiriSalvezza> tiriSalvezza = new ArrayList<>();
//            for (TiriSalvezza tiriSalvezzaEntity : characterPg.getTiriSalvezza()) {
//                Optional<TiriSalvezza> optionalTiriSalvezza = tiriSalvezzaRepository.findById(tiriSalvezzaEntity.getId());
//                if (optionalTiriSalvezza.isEmpty()) {
//                    throw new EntityNotFoundException("TiriSalvezza con id: " + tiriSalvezzaEntity.getId() + " non trovato");
//                }
//                tiriSalvezza.add(optionalTiriSalvezza.get());
//            }
//            characterPg.setTiriSalvezza(tiriSalvezza);
//        }
//
//        // 3.7. Campagna: prendo il campagnaId passato come argomento
//        if (campaignId == 0) {  // Usa 0 come valore di default per long
//            throw new EntityNotFoundException("ID campagna non fornito");
//        }
//
//        Optional<Campaign> optionalCampaign = campaignRepository.findById(campaignId);
//        if (optionalCampaign.isEmpty()) {
//            throw new EntityNotFoundException("Campaign con id: " + campaignId + " non trovato");
//        }
//        characterPg.setCampaign(optionalCampaign.get());
//
//
//        // 3.8. Talents: inizializzati vuoti
//        if (characterPg.getTalents() == null) {
//            characterPg.setTalents(new ArrayList<>());
//        } else {
//            List<Talent> talents = new ArrayList<>();
//            for (Talent talent : characterPg.getTalents()) {
//                Optional<Talent> optionalTalent = talentRepository.findById(talent.getId());
//                if (optionalTalent.isEmpty()) {
//                    throw new EntityNotFoundException("Talent con id: " + talent.getId() + " non trovato");
//                }
//                talents.add(optionalTalent.get());
//            }
//            characterPg.setTalents(talents);
//        }
//
//        // 3.9. Traits: inizializzati vuoti
//        if (characterPg.getTraits() == null) {
//            characterPg.setTraits(new ArrayList<>());
//        } else {
//            List<Trait> traits = new ArrayList<>();
//            for (Trait trait : characterPg.getTraits()) {
//                Optional<Trait> optionalTrait = traitRepository.findById(trait.getId());
//                if (optionalTrait.isEmpty()) {
//                    throw new EntityNotFoundException("Trait con id: " + trait.getId() + " non trovato");
//                }
//                traits.add(optionalTrait.get());
//            }
//            characterPg.setTraits(traits);
//        }
//
//        // 4. Salvo il CharacterPg nel database
//        return characterPgRepository.save(characterPg);
//    }










//    @Override
//    public CharacterPg createCharacterPg(CharacterPg characterPg, long userId, long campaignId) throws EntityNotFoundException {
//        // 1. Recupero l'utente associato tramite userId (già passato da @AuthenticationPrincipal nel controller)
//        Optional<User> optionalUser = userDetailRepository.findById(userId);
//        if (optionalUser.isEmpty()) {
//            throw new EntityNotFoundException("Utente con id: " + userId + " non trovato");
//        }
//        User user = optionalUser.get();
//        characterPg.setUser(user);  // Associa l'utente al CharacterPg
//
//        // 2. Associazione al campaignId
//        Optional<Campaign> optionalCampaign = campaignRepository.findById(campaignId);
//        if (optionalCampaign.isEmpty()) {
//            throw new EntityNotFoundException("Campagna con id: " + campaignId + " non trovata");
//        }
//        characterPg.setCampaign(optionalCampaign.get());  // Associa la campagna
//
//        // 3. Gestione della borsa
//        if (characterPg.getBag() == null) {
//            Bag newBag = new Bag();  // Crea un nuovo oggetto vuoto Bag
//            characterPg.setBag(newBag);  // Associa il nuovo zaino al personaggio
//        } else {
//            Optional<Bag> optionalBag = bagRepository.findById(characterPg.getBag().getId());
//            if (optionalBag.isEmpty()) {
//                throw new EntityNotFoundException("Bag con id: " + characterPg.getBag().getId() + " non trovato");
//            }
//            characterPg.setBag(optionalBag.get());  // Associa la borsa al personaggio
//        }
//
//        // 4. Gestione del diario
//        if (characterPg.getDiary() == null) {
//            Diary newDiary = new Diary();  // Crea un nuovo diario vuoto
//            characterPg.setDiary(newDiary);  // Associa il diario al personaggio
//        } else {
//            Optional<Diary> optionalDiary = diaryRepository.findById(characterPg.getDiary().getId());
//            if (optionalDiary.isEmpty()) {
//                throw new EntityNotFoundException("Diary con id: " + characterPg.getDiary().getId() + " non trovato");
//            }
//            characterPg.setDiary(optionalDiary.get());  // Associa il diario al personaggio
//        }
//
//        // 5. Gestione delle abilità
//        if (characterPg.getAbilityPgs() != null) {
//            List<AbilityPg> abilityPgs = new ArrayList<>();
//            for (AbilityPg abilityPgDto : characterPg.getAbilityPgs()) {
//                Optional<Ability> optionalAbility = abilityRepository.findById(abilityPgDto.getAbilityId());
//                if (optionalAbility.isEmpty()) {
//                    throw new EntityNotFoundException("Ability con id: " + abilityPgDto.getAbilityId() + " non trovata");
//                }
//                Ability ability = optionalAbility.get();
//                AbilityPg abilityPg = new AbilityPg();
//                abilityPg.setAbility(ability);
//                abilityPg.setCompetence(abilityPgDto.isCompetence());
//                abilityPg.setPoint(abilityPgDto.getPoint());
//                abilityPg.setPg(characterPg);  // Associa AbilityPg al CharacterPg
//                abilityPgs.add(abilityPg);
//            }
//            characterPg.setAbilityPgs(abilityPgs);  // Imposta la lista di AbilityPg
//        }
//
//        // 6. Gestione dei tiri salvezza
//        if (characterPg.getTiriSalvezza() != null) {
//            List<TiriSalvezza> tiriSalvezza = new ArrayList<>();
//            for (TiriSalvezzaDto tiriSalvezzaDto : characterPg.getTiriSalvezza()) {
//                Optional<TiriSalvezza> optionalTiriSalvezza = tiriSalvezzaRepository.findById(tiriSalvezzaDto.getId());
//                if (optionalTiriSalvezza.isEmpty()) {
//                    throw new EntityNotFoundException("TiriSalvezza con id: " + tiriSalvezzaDto.getId() + " non trovato");
//                }
//                tiriSalvezza.add(optionalTiriSalvezza.get());  // Aggiungi il TiriSalvezza alla lista
//            }
//            characterPg.setTiriSalvezza(tiriSalvezza);  // Imposta i tiri salvezza
//        }
//
//        // 7. Gestione dei talenti
//        if (characterPg.getTalents() == null) {
//            characterPg.setTalents(new ArrayList<>());
//        } else {
//            List<Talent> talents = new ArrayList<>();
//            for (TalentDto talentDto : characterPg.getTalents()) {
//                Optional<Talent> optionalTalent = talentRepository.findById(talentDto.getId());
//                if (optionalTalent.isEmpty()) {
//                    throw new EntityNotFoundException("Talent con id: " + talentDto.getId() + " non trovato");
//                }
//                talents.add(optionalTalent.get());
//            }
//            characterPg.setTalents(talents);  // Imposta la lista di talenti
//        }
//
//        // 8. Gestione dei tratti
//        if (characterPg.getTraits() == null) {
//            characterPg.setTraits(new ArrayList<>());
//        } else {
//            List<Trait> traits = new ArrayList<>();
//            for (TraitDto traitDto : characterPg.getTraits()) {
//                Optional<Trait> optionalTrait = traitRepository.findById(traitDto.getId());
//                if (optionalTrait.isEmpty()) {
//                    throw new EntityNotFoundException("Trait con id: " + traitDto.getId() + " non trovato");
//                }
//                traits.add(optionalTrait.get());
//            }
//            characterPg.setTraits(traits);  // Imposta i tratti
//        }
//
//        // 9. Salvo il CharacterPg nel database
//        return characterPgRepository.save(characterPg);  // Salva il personaggio
//    }




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

        Optional<Campaign> optionalCampaign = campaignRepository.findById(campaignId);
        if (optionalCampaign.isEmpty()) {
            throw new EntityNotFoundException("Campagna con id: " + campaignId + " non trovata");
        }
        characterPg.setCampaign(optionalCampaign.get());  // Associa la campagna

        // 3. Gestione della borsa
        Bag bag = new Bag();
        characterPg.setBag(bag);

        // 4. Gestione del diario
        Diary diary = new Diary();
        characterPg.setDiary(diary);



        if (characterPg.getSlots() == null) {
            characterPg.setSlots(new ArrayList<>());
        } else {
            List<Slot> slots = new ArrayList<>();
            for (Slot slot : characterPg.getSlots()) {
                Optional<Slot> optionalSlot = slotRepository.findById(slot.getId());
                if (optionalSlot.isEmpty()) {
                    throw new EntityNotFoundException("Slot con id: " + slot.getId() + " non trovato");
                }
                slots.add(optionalSlot.get());
            }
            characterPg.setSlots(slots);
        }


        for(AbilityPg a: characterPg.getAbilityPgs()){
            System.out.println(a.getId());
        }



        // 5. Gestione delle abilità

        //characterPg.setAbilityPgs(resolveAbilityPgs(characterPg.getAbilityPgs(), characterPg));

//        for (AbilityPg abilityPg: characterPg.getAbilityPgs()){
//            System.out.println("id" + abilityPg.getAbility().getId());
//            Optional<Ability> a =  abilityRepository.findById(abilityPg.getAbility().getId());
//
//            if(a.isEmpty()){
//                throw  new EntityNotFoundException("Ingrediente con id: " + abilityPg.getAbility().getId() + " non è stato trovato");
//            }
//            abilityPg.setAbility(a.get());
//            abilityPg.setPg(characterPg);
//
//        }




        for (AbilityPg abilityPg : characterPg.getAbilityPgs()) {
            if (abilityPg.getAbility() == null || abilityPg.getAbility().getId() == 0) {
                throw new EntityNotFoundException("Ability non presente nel JSON o senza ID." + abilityPg.getAbility() + abilityPg);
            }
            System.out.println("Ability ID ricevuto: " + abilityPg.getAbility().getId());
            Optional<Ability> optionalAbility = abilityRepository.findById(abilityPg.getAbility().getId());

            if (optionalAbility.isEmpty()) {
                throw new EntityNotFoundException("Ability con id: " + abilityPg.getAbility().getId() + " non trovata nel database");
            }

            abilityPg.setAbility(optionalAbility.get());
            abilityPg.setPg(characterPg);
        }








        // 6. Gestione dei tiri salvezza
        characterPg.setTiriSalvezza(resolveTiriSalvezza(characterPg.getTiriSalvezza()));

        // 7. Gestione dei talenti
        characterPg.setTalents(resolveTalents(characterPg.getTalents()));

        // 8. Gestione dei tratti
        characterPg.setTraits(resolveTraits(characterPg.getTraits()));

        // 9. Salvo il CharacterPg nel database
        return characterPgRepository.save(characterPg);  // Salva il personaggio
    }




    // Metodo per risolvere la borsa
    private Bag resolveBag(Bag bag) throws EntityNotFoundException {
        if (bag == null) {
            return new Bag();  // Crea un nuovo oggetto vuoto Bag
        } else {
            return bagRepository.findById(bag.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Bag con id: " + bag.getId() + " non trovato"));
        }
    }

    // Metodo per risolvere il diario
    private Diary resolveDiary(Diary diary) throws EntityNotFoundException {
        if (diary == null) {
            return new Diary();  // Crea un nuovo diario vuoto
        } else {
            return diaryRepository.findById(diary.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Diary con id: " + diary.getId() + " non trovato"));
        }
    }

    // Metodo per risolvere le abilità
    private List<AbilityPg> resolveAbilityPgs(List<AbilityPg> abilityPgs, CharacterPg characterPg) throws EntityNotFoundException {
        if (abilityPgs == null) {
            return new ArrayList<>();
        }

        List<AbilityPg> resolvedAbilityPgs = new ArrayList<>();
        for (AbilityPg abilityPg : abilityPgs) {
            Ability ability = abilityRepository.findById(abilityPg.getAbility().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Ability con id: " + abilityPg.getAbility().getId() + " non trovata"));

            abilityPg.setAbility(ability);  // Associa l'abilità
            abilityPg.setPg(characterPg);  // Associa AbilityPg al CharacterPg
            resolvedAbilityPgs.add(abilityPg);
        }
        return resolvedAbilityPgs;
    }

    // Metodo per risolvere i tiri salvezza
    private List<TiriSalvezza> resolveTiriSalvezza(List<TiriSalvezza> tiriSalvezza) throws EntityNotFoundException {
        if (tiriSalvezza == null) {
            return new ArrayList<>();
        }

        List<TiriSalvezza> resolvedTiriSalvezza = new ArrayList<>();
        for (TiriSalvezza tiriSalvezzaEntity : tiriSalvezza) {
            TiriSalvezza tiriSalvezzaResolved = tiriSalvezzaRepository.findById(tiriSalvezzaEntity.getId())
                    .orElseThrow(() -> new EntityNotFoundException("TiriSalvezza con id: " + tiriSalvezzaEntity.getId() + " non trovato"));
            resolvedTiriSalvezza.add(tiriSalvezzaResolved);  // Aggiungi il TiriSalvezza alla lista
        }
        return resolvedTiriSalvezza;
    }

    // Metodo per risolvere i talenti
    private List<Talent> resolveTalents(List<Talent> talents) throws EntityNotFoundException {
        if (talents == null) {
            return new ArrayList<>();
        }

        List<Talent> resolvedTalents = new ArrayList<>();
        for (Talent talent : talents) {
            Talent talentResolved = talentRepository.findById(talent.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Talent con id: " + talent.getId() + " non trovato"));
            resolvedTalents.add(talentResolved);  // Aggiungi il Talent alla lista
        }
        return resolvedTalents;
    }

    // Metodo per risolvere i tratti
    private List<Trait> resolveTraits(List<Trait> traits) throws EntityNotFoundException {
        if (traits == null) {
            return new ArrayList<>();
        }

        List<Trait> resolvedTraits = new ArrayList<>();
        for (Trait trait : traits) {
            Trait traitResolved = traitRepository.findById(trait.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Trait con id: " + trait.getId() + " non trovato"));
            resolvedTraits.add(traitResolved);  // Aggiungi il Trait alla lista
        }
        return resolvedTraits;
    }








}
