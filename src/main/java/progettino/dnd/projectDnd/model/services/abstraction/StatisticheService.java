package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.dtos.StaticDto;
import progettino.dnd.projectDnd.model.entities.Statistiche;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;
import java.util.Map;

public interface StatisticheService {
    Statistiche createStaticPg(long characterId, Statistiche statics) throws EntityNotFoundException;
    Statistiche updateStatic(long id, Statistiche statics) throws EntityNotFoundException;
    List<StaticDto> getStaticsByCharacter(Long characterId);
    Statistiche updateStaticFields(Long id, Map<String, Object> updates);
}
