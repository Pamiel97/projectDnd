package progettino.dnd.projectDnd.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterPgRepository extends JpaRepository<CharacterPg, Long> {

    Optional<CharacterPg> findByName(String name);
    List<CharacterPg> findByUserId(Long userId);
    List<CharacterPg> findByCampaignId(Long campaignId);

    @Query("SELECT c FROM CharacterPg c WHERE c.level >= :minLevel AND c.campaign.id = :campaignId")
    List<CharacterPg> findHighLevelCharactersByCampaign(
            @Param("minLevel") int minLevel,
            @Param("campaignId") Long campaignId
    );

    Optional<CharacterPg> findByNameAndUser(String name, User user);
    List<CharacterPg> findByUser_IdAndCampaign_Id(Long userId, Long campaignId);
}
