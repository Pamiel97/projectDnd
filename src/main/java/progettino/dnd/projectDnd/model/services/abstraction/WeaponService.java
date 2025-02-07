package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Equip;
import progettino.dnd.projectDnd.model.entities.Weapon;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

public interface WeaponService {
    Weapon createWeapon(long bagId, Weapon weapon) throws EntityNotFoundException;

}
