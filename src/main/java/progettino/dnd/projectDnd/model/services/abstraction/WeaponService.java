package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Equip;
import progettino.dnd.projectDnd.model.entities.Weapon;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface WeaponService {
    Weapon createWeapon(long bagId, Weapon weapon) throws EntityNotFoundException;
    void deleteWeapon(Long id);
    List<Weapon> getWeaponsByBag(Long bagId);
}
