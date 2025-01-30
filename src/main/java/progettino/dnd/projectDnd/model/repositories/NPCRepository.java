package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import progettino.dnd.projectDnd.model.entities.NPC;

public interface NPCRepository extends JpaRepository<NPC, Long> {
}
