package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import progettino.dnd.projectDnd.dtos.CharacterPgDto;
import progettino.dnd.projectDnd.dtos.StaticDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Statistiche;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.StatisticheRepository;
import progettino.dnd.projectDnd.model.services.abstraction.StatisticheService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StatisticheJpa implements StatisticheService {




    private CharacterPgRepository characterPgRepository;
    private StatisticheRepository staticRepository;

    @Autowired
    public StatisticheJpa(CharacterPgRepository characterPgRepository, StatisticheRepository staticRepository) {
        this.characterPgRepository = characterPgRepository;
        this.staticRepository = staticRepository;
    }

    @Override
    @Transactional
    public Statistiche createStaticPg(long characterId, Statistiche statics) throws EntityNotFoundException {
        CharacterPg pg = characterPgRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("Pg not found for ID: " + characterId));

        statics.setPg(pg);
        return staticRepository.save(statics);
    }



    @Override
    @Transactional
    public Statistiche updateStatic(long id, Statistiche statics) throws EntityNotFoundException {

        Statistiche existingStatic = staticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Static not found for ID: " + id));


        existingStatic.setPoint(statics.getPoint());
        existingStatic.setModificatore((statics.getModificatore()));

        return staticRepository.save(existingStatic);
    }

    @Override
    public List<StaticDto> getStaticsByCharacter(Long characterId) {
        List<Statistiche> statics = staticRepository.findByPgId(characterId);
        return statics.stream()
                .map(StaticDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public Statistiche updateStaticFields(Long id, Map<String, Object> updates) {
        Optional<Statistiche> optionalStat = staticRepository.findById(id);
        if (optionalStat.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Static not found");
        }

        Statistiche statics = optionalStat.get();

        updates.forEach((key, value) -> {
            try {
                Field field = Statistiche.class.getDeclaredField(key); // Usa Statistiche
                field.setAccessible(true); // Permette di accedere ai campi privati

                if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                    field.set(statics, ((Number) value).intValue());
                } else if (field.getType().equals(double.class) || field.getType().equals(Double.class)) {
                    field.set(statics, ((Number) value).doubleValue());
                } else if (field.getType().equals(String.class)) {
                    field.set(statics, value.toString());
                } else {
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

        return staticRepository.save(statics);
    }




}
