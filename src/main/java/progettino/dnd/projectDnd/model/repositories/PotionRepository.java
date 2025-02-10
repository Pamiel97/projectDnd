package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.Potion;

import java.util.List;

@Repository
public interface PotionRepository extends JpaRepository<Potion, Long> {
    List<Potion> findByBagId(Long bagId);
}
