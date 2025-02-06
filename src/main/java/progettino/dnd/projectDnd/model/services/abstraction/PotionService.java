package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

public interface PotionService {
    Potion createPotion(long bagId, Potion potion) throws EntityNotFoundException;
}
