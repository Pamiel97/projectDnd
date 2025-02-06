package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Equip;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

public interface EquipService {
    Equip createEquip(long bagId, Equip equip) throws EntityNotFoundException;
}
