package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.TiriSalvezzaDto;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.CharacterPgRepository;
import progettino.dnd.projectDnd.model.repositories.TiriSalvezzaRepository;
import progettino.dnd.projectDnd.model.services.abstraction.TiriSalvezzaPgService;

import java.util.List;
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
}
