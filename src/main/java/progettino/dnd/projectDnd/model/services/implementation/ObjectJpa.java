package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.Object;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.BagRepository;
import progettino.dnd.projectDnd.model.repositories.ObjectRepository;
import progettino.dnd.projectDnd.model.repositories.PotionRepository;
import progettino.dnd.projectDnd.model.services.abstraction.ObjectService;

import java.util.List;

@Service
public class ObjectJpa implements ObjectService {

    private ObjectRepository objectRepository;
    private BagRepository bagRepository;

    @Autowired
    public ObjectJpa(ObjectRepository objectRepository, BagRepository bagRepository) {
        this.objectRepository = objectRepository;
        this.bagRepository = bagRepository;
    }

    @Override
    public Object createObject(long bagId, Object object) throws EntityNotFoundException {
        Bag bag = bagRepository.findById(bagId)
                .orElseThrow(() -> new EntityNotFoundException("Bag with id " + bagId + " not found."));

        object.setBag(bag);

        return objectRepository.save(object);
    }

    @Override
    @Transactional
    public void deleteObject(Long id) {
        if (!objectRepository.existsById(id)) {
            throw new RuntimeException("GameObject with ID " + id + " not found.");
        }
        objectRepository.deleteById(id);
    }

    @Override
    public List<Object> getObjectsByBag(Long bagId) {
        return objectRepository.findByBagId(bagId);
    }
}
