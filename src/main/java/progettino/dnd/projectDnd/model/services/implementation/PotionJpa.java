package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.BagRepository;
import progettino.dnd.projectDnd.model.repositories.PotionRepository;
import progettino.dnd.projectDnd.model.services.abstraction.PotionService;

@Service
public class PotionJpa implements PotionService {


    private PotionRepository potionRepository;
    private BagRepository bagRepository;

    public PotionJpa(PotionRepository potionRepository, BagRepository bagRepository) {
        this.potionRepository = potionRepository;
        this.bagRepository = bagRepository;
    }

    @Override
    public Potion createPotion(long bagId, Potion potion) throws EntityNotFoundException {
        Bag bag = bagRepository.findById(bagId)
                .orElseThrow(() -> new EntityNotFoundException("Bag with id " + bagId + " not found."));

        potion.setBag(bag);

        return potionRepository.save(potion);
    }
}
