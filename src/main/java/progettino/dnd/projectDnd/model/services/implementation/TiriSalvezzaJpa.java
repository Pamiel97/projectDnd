package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import progettino.dnd.projectDnd.dtos.TiriSalvezzaDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.TiriSalvezzaRepository;
import progettino.dnd.projectDnd.model.services.abstraction.TiriSalvezzaPgService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiriSalvezzaJpa implements TiriSalvezzaPgService{

    private CharacterPgRepository characterPgRepository;
    private TiriSalvezzaRepository tiriSalvezzaRepository;

    @Autowired
    public TiriSalvezzaJpa(CharacterPgRepository characterPgRepository, TiriSalvezzaRepository tiriSalvezzaRepository) {
        this.characterPgRepository = characterPgRepository;
        this.tiriSalvezzaRepository = tiriSalvezzaRepository;
    }

    @Override
    public TiriSalvezza createTiriSalvezza(long id, TiriSalvezza ts) throws EntityNotFoundException {
        Optional<CharacterPg> pg = characterPgRepository.findById(id);
        ts.setPg(pg.get());
        TiriSalvezza newTiri = tiriSalvezzaRepository.save(ts);
        return ts;
    }

    @Override
    public List<TiriSalvezzaDto> getTiriSalvezzaByCharacter(Long characterId) {
        List<TiriSalvezza> tiriSalvezzaList = tiriSalvezzaRepository.findByPgId(characterId);
        return tiriSalvezzaList.stream()
                .map(TiriSalvezzaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TiriSalvezza updatetiri(long id, TiriSalvezza ts) throws EntityNotFoundException {

        TiriSalvezza existingTiri = tiriSalvezzaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Static not found for ID: " + id));
        existingTiri.setPoint(ts.getPoint());
        existingTiri.setCompetenza(ts.getCompetenza());

        return tiriSalvezzaRepository.save(existingTiri);
    }



    @Override
    public TiriSalvezza updateTiriSalvezzaField(long id, Map<String, Object> updates) {
        Optional<TiriSalvezza> optionalTiri = tiriSalvezzaRepository.findById(id);
        if (optionalTiri.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TiriSalvezza not found");
        }

        TiriSalvezza tiriSalvezza = optionalTiri.get();

        updates.forEach((key, value) -> {
            try {
                // Trova il campo nell'entità TiriSalvezza
                Field field = TiriSalvezza.class.getDeclaredField(key);
                field.setAccessible(true);

                // Se il valore è null, throw error
                if (value == null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Field value cannot be null: " + key);
                }

                // Gestione dei tipi di dati per ciascun campo
                if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                    field.set(tiriSalvezza, ((Number) value).intValue());
                } else if (field.getType().equals(double.class) || field.getType().equals(Double.class)) {
                    field.set(tiriSalvezza, ((Number) value).doubleValue());
                } else if (field.getType().equals(String.class)) {
                    field.set(tiriSalvezza, value.toString());
                } else if (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)) {
                    if (value instanceof String) {
                        field.set(tiriSalvezza, Boolean.parseBoolean((String) value));
                    } else if (value instanceof Boolean) {
                        field.set(tiriSalvezza, value);
                    } else {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid boolean value for field: " + key);
                    }
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid field type: " + key);
                }

            } catch (NoSuchFieldException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Field not found: " + key);
            } catch (IllegalAccessException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating field: " + key);
            } catch (ClassCastException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data type for field: " + key);
            }
        });

        // Salva e restituisci l'entità aggiornata
        TiriSalvezza updatedTiriSalvezza = tiriSalvezzaRepository.save(tiriSalvezza);
        return updatedTiriSalvezza;
    }




}
