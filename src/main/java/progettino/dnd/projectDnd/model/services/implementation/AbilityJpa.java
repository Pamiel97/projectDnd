package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.AbilityRepository;
import progettino.dnd.projectDnd.model.services.abstraction.AbilityService;

import java.util.Optional;
@Service
public class AbilityJpa implements AbilityService {

    private final AbilityRepository abilityRepository;

    @Autowired
    public AbilityJpa(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    @Override
    public Optional<Ability> findById(long id) {
        return abilityRepository.findById(id);
    }
}
