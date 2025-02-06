package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.NPC;

import java.util.List;

public interface NPCRepository extends JpaRepository<NPC, Long> {
    List<NPC> findByCampaignId(Long campaignId);
}
