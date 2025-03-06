package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.Slot;

import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    List<Slot> findByPgId(Long characterId);
    Optional<Slot> findById(Long slotId);
}
