package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(long id);
}
