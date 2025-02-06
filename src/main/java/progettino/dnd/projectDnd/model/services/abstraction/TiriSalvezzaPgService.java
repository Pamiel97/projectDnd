package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Static;
import progettino.dnd.projectDnd.dtos.TiriSalvezzaDto;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface TiriSalvezzaPgService {
    TiriSalvezza createTiriSalvezza( long id, TiriSalvezza ts) throws EntityNotFoundException;
    List<TiriSalvezzaDto> getTiriSalvezzaByCharacter(Long characterId);
    TiriSalvezza updatetiri(long id, TiriSalvezza ts) throws EntityNotFoundException;
}
