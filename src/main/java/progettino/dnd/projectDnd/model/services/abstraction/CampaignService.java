package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.NPC;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CampaignService {
    Optional<Campaign> findCampaignById(long id);
    Campaign createCampaign(Campaign campaign, long userId) throws EntityNotFoundException;
    public List<Campaign> getCampaignsByUserId(long userId)throws EntityNotFoundException;
}
