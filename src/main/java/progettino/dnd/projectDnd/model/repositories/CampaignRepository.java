package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    Optional<Campaign> findById(long id);

    @Query("SELECT c FROM Campaign c WHERE c.user = :user AND c.isActive = true")
    Optional<Campaign> findActiveByUser(@Param("user") User user);

    List<Campaign> findByUser_Id(Long userId);

    @Query("SELECT c FROM Campaign c WHERE c.status = 'ACTIVE' AND c.startDate <= CURRENT_DATE")
    List<Campaign> findCurrentCampaigns();
}
