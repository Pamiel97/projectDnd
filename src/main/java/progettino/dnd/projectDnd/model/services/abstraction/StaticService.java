package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Static;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

public interface StaticService {
    Static createStaticPg(long characterId, Static statics) throws EntityNotFoundException;
    Static updateStatic(long id, Static statics) throws EntityNotFoundException;
}
