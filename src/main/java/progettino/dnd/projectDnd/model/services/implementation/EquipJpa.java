package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.Equip;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.BagRepository;
import progettino.dnd.projectDnd.model.repositories.EquipRepository;
import progettino.dnd.projectDnd.model.repositories.PotionRepository;
import progettino.dnd.projectDnd.model.services.abstraction.EquipService;

import java.util.List;

@Service
public class EquipJpa implements EquipService {

    private EquipRepository equipRepository;
    private BagRepository bagRepository;

    @Autowired
    public EquipJpa(EquipRepository equipRepository, BagRepository bagRepository) {
        this.equipRepository = equipRepository;
        this.bagRepository = bagRepository;
    }


    @Override
    public Equip createEquip(long bagId, Equip equip) throws EntityNotFoundException {
        Bag bag = bagRepository.findById(bagId)
                .orElseThrow(() -> new EntityNotFoundException("Bag with id " + bagId + " not found."));
        equip.setBag(bag);
        return  equipRepository.save(equip);
    }

    @Override
    @Transactional
    public void deleteEquip(Long id) {
        if (!equipRepository.existsById(id)) {
            throw new RuntimeException("Equip with ID " + id + " not found.");
        }
        equipRepository.deleteById(id);
    }

    @Override
    public List<Equip> getEquipsByBag(Long bagId) {
        return equipRepository.findByBagId(bagId);
    }
}
