package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.entities.Weapon;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.BagRepository;
import progettino.dnd.projectDnd.model.repositories.PotionRepository;
import progettino.dnd.projectDnd.model.repositories.WeaponRepository;
import progettino.dnd.projectDnd.model.services.abstraction.WeaponService;

@Service
public class WeaponJpa implements WeaponService {

    private WeaponRepository weaponRepository;
    private BagRepository bagRepository;

    @Autowired
    public WeaponJpa(WeaponRepository weaponRepository, BagRepository bagRepository) {
        this.weaponRepository = weaponRepository;
        this.bagRepository = bagRepository;
    }




    @Override
    public Weapon createWeapon(long bagId, Weapon weapon) throws EntityNotFoundException {
        Bag bag = bagRepository.findById(bagId)
                .orElseThrow(() -> new EntityNotFoundException("Bag with id " + bagId + " not found."));

        weapon.setBag(bag);

        return weaponRepository.save(weapon);
    }
}
