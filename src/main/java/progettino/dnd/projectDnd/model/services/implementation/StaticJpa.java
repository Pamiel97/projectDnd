package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.StaticDto;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.AbilityPg;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Static;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.StaticRepository;
import progettino.dnd.projectDnd.model.services.abstraction.StaticService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaticJpa implements StaticService {




    private CharacterPgRepository characterPgRepository;
    private StaticRepository staticRepository;

    @Autowired
    public StaticJpa(CharacterPgRepository characterPgRepository, StaticRepository staticRepository) {
        this.characterPgRepository = characterPgRepository;
        this.staticRepository = staticRepository;
    }

    @Override
    @Transactional
    public Static createStaticPg(long characterId, Static statics) throws EntityNotFoundException {
        CharacterPg pg = characterPgRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("Pg not found for ID: " + characterId));

        statics.setPg(pg);
        return staticRepository.save(statics);
    }


    //TODO
    @Override
    @Transactional
    public Static updateStatic(long id, Static statics) throws EntityNotFoundException {
        // Recupera lo Static esistente dal database
        Static existingStatic = staticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Static not found for ID: " + id));

//        // Verifica che l'ID dell'oggetto passato nel body corrisponda a quello nel path
//        if (existingStatic.getId() != statics.getId()) {
//            throw new IllegalArgumentException("Gli ID non coincidono: " + id + " != " + statics.getId());
//        }

        existingStatic.setPoint(statics.getPoint());
        existingStatic.setModificatore((statics.getModificatore()));

        return staticRepository.save(existingStatic);
    }

    @Override
    public List<StaticDto> getStaticsByCharacter(Long characterId) {
        List<Static> statics = staticRepository.findByPgId(characterId);
        return statics.stream()
                .map(StaticDto::fromEntity)
                .collect(Collectors.toList());
    }
}
