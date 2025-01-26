package progettino.dnd.projectDnd.model.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import progettino.dnd.projectDnd.model.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
