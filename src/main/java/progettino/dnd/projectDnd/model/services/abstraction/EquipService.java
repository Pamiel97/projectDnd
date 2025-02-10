package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Equip;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface EquipService {
    Equip createEquip(long bagId, Equip equip) throws EntityNotFoundException;
    void deleteEquip(Long id);
    List<Equip> getEquipsByBag(Long bagId);
}
