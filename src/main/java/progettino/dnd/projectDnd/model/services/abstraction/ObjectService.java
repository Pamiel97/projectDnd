package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Object;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

public interface ObjectService {
    Object createObject(long bagId, Object object) throws EntityNotFoundException;
}
