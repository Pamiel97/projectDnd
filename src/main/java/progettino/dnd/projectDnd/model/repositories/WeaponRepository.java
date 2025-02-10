package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.Weapon;

import java.util.List;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {

    List<Weapon> findByBagId(Long bagId);
}
