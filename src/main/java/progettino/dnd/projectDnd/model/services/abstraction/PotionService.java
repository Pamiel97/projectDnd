package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface PotionService {
    Potion createPotion(long bagId, Potion potion) throws EntityNotFoundException;
    void deletePotion(Long id);
    List<Potion> getPotionsByBag(Long bagId);
}
