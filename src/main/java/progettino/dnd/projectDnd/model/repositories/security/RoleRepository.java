package progettino.dnd.projectDnd.model.repositories.security;

import org.springframework.data.jpa.repository.JpaRepository;
import progettino.dnd.projectDnd.model.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
