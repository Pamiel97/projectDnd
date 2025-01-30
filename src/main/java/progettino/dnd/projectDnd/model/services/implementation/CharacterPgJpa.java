package progettino.dnd.projectDnd.model.services.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Slot;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.UserDetailRepository;
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

    @Override
    public CharacterPgDto createCharacterPg(CharacterPg characterPg, long userId, long campaignId) throws EntityNotFoundException {
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
                Optional<AbilityPg> optionalAbilityPg = abilityPgRepository.findById(abilityPg.getId());
                if (optionalAbilityPg.isEmpty()) {
                    throw new EntityNotFoundException("AbilityPg con id: " + abilityPg.getId() + " non trovato");
                }
                abilityPgs.add(optionalAbilityPg.get());
            }
            characterPg.setAbilityPgs(abilityPgs);
        }

        // 3.5. StaticList
        if (characterPg.getStaticList() != null) {
            List<Static> staticList = new ArrayList<>();
            for (Static staticEntity : characterPg.getStaticList()) {
                Optional<Static> optionalStatic = staticRepository.findById(staticEntity.getId());
                if (optionalStatic.isEmpty()) {
                    throw new EntityNotFoundException("Static con id: " + staticEntity.getId() + " non trovato");
                }
                staticList.add(optionalStatic.get());
            }
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
        if (campaignId != null) {
            Optional<Campaign> optionalCampaign = campaignRepository.findById(campaignId);
            if (optionalCampaign.isEmpty()) {
                throw new EntityNotFoundException("Campaign con id: " + campaignId + " non trovato");
            }
            characterPg.setCampaign(optionalCampaign.get());
        } else {
            throw new EntityNotFoundException("ID campagna non fornito");
        }

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
