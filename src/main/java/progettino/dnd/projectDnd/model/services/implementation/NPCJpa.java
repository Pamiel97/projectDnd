package progettino.dnd.projectDnd.model.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.NPC;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.mapper.NPCMapper;
import progettino.dnd.projectDnd.model.repositories.CampaignRepository;
import progettino.dnd.projectDnd.model.repositories.NPCRepository;
import progettino.dnd.projectDnd.model.services.abstraction.NPCService;

import java.util.Optional;

@Service
public class NPCJpa implements NPCService {
    private NPCRepository npcRepository;
    private CampaignRepository campaignRepository;
    private NPCMapper npcMapper;

    @Autowired
    public NPCJpa(NPCMapper npcMapper, NPCRepository npcRepository, CampaignRepository campaignRepository ) {
        this.npcMapper = npcMapper;
        this.npcRepository=npcRepository;
        this.campaignRepository=campaignRepository;
    }

//    public NPC createNPC(NPCDto npcDto, long campaignId) throws EntityNotFoundException {
//        NPC npc = npcMapper.toEntity(npcDto);
//        // Aggiunta logica aziendale
//        npc.setCampaign(campaignRepository.findById(campaignId)
//                .orElseThrow(() -> new EntityNotFoundException("Campagna non trovata")));
//        return npcRepository.save(npc);
//    }



    @Override
    public NPC createNPC(NPC npc, long CampaignId) throws EntityNotFoundException {
        Optional<Campaign> optionalCampaign = campaignRepository.findById(CampaignId);
        if(optionalCampaign.isEmpty()){
            throw new EntityNotFoundException("Campagna con id: " + CampaignId + " non è stata trovata" );
        }
        npc.setCampaign(optionalCampaign.get());
        return npcRepository.save(npc);
    }

}
