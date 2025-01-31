package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.Optional;

public interface AbilityService {
    Optional<Ability> findById(long id);
}
