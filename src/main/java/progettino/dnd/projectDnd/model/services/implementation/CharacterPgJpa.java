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

    @Override
    public List<CharacterPg> getAllCharacterPgs() {
        return characterPgRepository.findAll();
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
