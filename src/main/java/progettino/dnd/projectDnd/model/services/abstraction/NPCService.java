package progettino.dnd.projectDnd.model.services.abstraction;

import progettino.dnd.projectDnd.model.entities.NPC;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

public interface NPCService {
    NPC createNPC(NPC npc, long CampaignId) throws EntityNotFoundException;

}
