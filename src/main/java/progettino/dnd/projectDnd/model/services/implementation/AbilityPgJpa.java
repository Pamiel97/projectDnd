package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import progettino.dnd.projectDnd.dtos.AbilityPgDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Statistiche;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import progettino.dnd.projectDnd.model.repositories.AbilityPgRepository;
import progettino.dnd.projectDnd.model.repositories.AbilityRepository;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityPgService;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityService;
import progettino.dnd.projectDnd.model.services.abstraction.CharacterPgService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbilityPgJpa implements AbilityPgService {

    private AbilityRepository abilityRepository;
    private AbilityPgRepository abilityPgRepository;
    private CharacterPgRepository characterPgRepository;


    @Autowired
    public AbilityPgJpa( AbilityRepository abilityRepository, AbilityPgRepository abilityPgRepository, CharacterPgRepository characterPgRepository) {

        this.abilityRepository = abilityRepository;
        this.abilityPgRepository = abilityPgRepository;
        this.characterPgRepository = characterPgRepository;
    }


    //Questo va ma dobbiamo capire come farne più insieme in una sola volta
    @Override
    @Transactional
    public AbilityPg createAbilityPg(AbilityPg abilityPg, long abilityId, long characterId) {
        Ability ability = abilityRepository.findById(abilityId)
                .orElseThrow(() -> new IllegalArgumentException("Ability not found for ID: " + abilityId));

        CharacterPg characterPg = characterPgRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("CharacterPg not found for ID: " + characterId));

        abilityPg.setAbility(ability);
        abilityPg.setPg(characterPg);

        return abilityPgRepository.save(abilityPg);
    }


    //QUESTO NON FUNGE
    @Override
    @Transactional
    public List<AbilityPg> createMultipleAbilityPgs(List<AbilityPg> abilityPgs, long characterId) {
        CharacterPg characterPg = characterPgRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("CharacterPg not found for ID: " + characterId));

        for (AbilityPg abilityPg : abilityPgs) {
            Ability ability = abilityRepository.findById(abilityPg.getAbility().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Ability not found for ID: " + abilityPg.getAbility().getId()));

            abilityPg.setAbility(ability);
            abilityPg.setPg(characterPg);
        }

        return abilityPgRepository.saveAll(abilityPgs);
    }

    public List<AbilityPgDto> getAbilitiesPgByCharacter(Long pgId) {
        List<AbilityPg> abilityPgs = abilityPgRepository.findByPgId(pgId);
        return abilityPgs.stream()
                .map(AbilityPgDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    @Transactional
    public AbilityPg updateAbilityPg(long id, AbilityPg updatedAbilityPg) throws EntityNotFoundException{
        // Recupero dell'entità esistente


        Optional<AbilityPg> existing = abilityPgRepository.findById(id);
        AbilityPg existingAbilityPg = existing.get();

        // Aggiornamento dei campi (controllando che siano valorizzati)
        if (updatedAbilityPg.getAbility() != null) {
            Ability ability = abilityRepository.findById(updatedAbilityPg.getAbility().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Ability not found for ID: " + updatedAbilityPg.getAbility().getId()));
            existingAbilityPg.setAbility(ability);
        }

        if (updatedAbilityPg.getPg() != null) {
            CharacterPg characterPg = characterPgRepository.findById(updatedAbilityPg.getPg().getId())
                    .orElseThrow(() -> new IllegalArgumentException("CharacterPg not found for ID: " + updatedAbilityPg.getPg().getId()));
            existingAbilityPg.setPg(characterPg);
        }

        // Aggiorna altri campi primitivi
        existingAbilityPg.setCompetence(updatedAbilityPg.isCompetence());
        existingAbilityPg.setPoint(updatedAbilityPg.getPoint());

        // Salvataggio nel repository
        return abilityPgRepository.save(existingAbilityPg);
    }



    @Override
    public AbilityPg updateAbilityPgField(long id, Map<String, Object> updates) {
        Optional<AbilityPg> optionalAbility = abilityPgRepository.findById(id);
        if (optionalAbility.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Static not found");
        }
        AbilityPg ab = optionalAbility.get();
        updates.forEach((key, value) -> {
            try {
                Field field = AbilityPg.class.getDeclaredField(key);
                field.setAccessible(true);

                // Gestione del tipo int o Integer
                if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                    field.set(ab, ((Number) value).intValue());
                }
                // Gestione del tipo double o Double
                else if (field.getType().equals(double.class) || field.getType().equals(Double.class)) {
                    field.set(ab, ((Number) value).doubleValue());
                }
                // Gestione del tipo String
                else if (field.getType().equals(String.class)) {
                    field.set(ab, value.toString());
                }
                // Gestione del tipo boolean o Boolean
                else if (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)) {
                    // Se il valore non è un booleano valido, potrebbe essere una stringa 'true'/'false' o un numero
                    if (value instanceof String) {
                        field.set(ab, Boolean.parseBoolean((String) value));
                    } else if (value instanceof Boolean) {
                        field.set(ab, value);
                    } else {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid boolean value for field: " + key);
                    }
                }
                // Se il tipo del campo non è supportato
                else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid field type: " + key);
                }
            } catch (NoSuchFieldException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid field: " + key);
            } catch (IllegalAccessException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating field: " + key);
            } catch (ClassCastException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data type for field: " + key);
            }
        });

        System.out.println("Updating AbilityPg: " + ab);
        AbilityPg updatedAbility = abilityPgRepository.save(ab);
        System.out.println("Updated AbilityPg: " + updatedAbility);
        return abilityPgRepository.save(ab);

    }





}
