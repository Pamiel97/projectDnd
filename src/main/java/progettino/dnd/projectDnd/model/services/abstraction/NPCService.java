package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.NPC;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import java.util.List;

public interface NPCService {
    NPC createNPC(NPC npc, long CampaignId) throws EntityNotFoundException;
    public List<NPC> getNPCsByCampaignId(long campaignId)throws EntityNotFoundException;

}
