package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Object;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface ObjectService {
    Object createObject(long bagId, Object object) throws EntityNotFoundException;
    void deleteObject(Long id);
    List<Object> getObjectsByBag(Long bagId);
}
