package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Static;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

public interface TiriSalvezzaPgService {
    TiriSalvezza createTiriSalvezza( long id, TiriSalvezza ts) throws EntityNotFoundException;
    TiriSalvezza updatetiri(long id, TiriSalvezza ts) throws EntityNotFoundException;
}
