package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.CharacterPg;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterPgRepository extends JpaRepository<CharacterPg, Long> {

    Optional<CharacterPg> findByName(String name);
    List<CharacterPg> findByUserId(Long userId);
    List<CharacterPg> findByCampaignId(Long campaignId);
}
