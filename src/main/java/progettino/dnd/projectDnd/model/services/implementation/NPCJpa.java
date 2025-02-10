package progettino.dnd.projectDnd.model.services.implementation;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettino.dnd.projectDnd.dtos.NPCDto;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.NPC;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;

import progettino.dnd.projectDnd.model.repositories.CampaignRepository;
import progettino.dnd.projectDnd.model.repositories.NPCRepository;
import progettino.dnd.projectDnd.model.services.abstraction.NPCService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NPCJpa implements NPCService {
    private NPCRepository npcRepository;
    private CampaignRepository campaignRepository;


    @Autowired
    public NPCJpa(NPCRepository npcRepository, CampaignRepository campaignRepository ) {

        this.npcRepository=npcRepository;
        this.campaignRepository=campaignRepository;
    }




    @Override
    public NPC createNPC(NPC npc, long CampaignId) throws EntityNotFoundException {
        Optional<Campaign> optionalCampaign = campaignRepository.findById(CampaignId);
        if(optionalCampaign.isEmpty()){
            throw new EntityNotFoundException("Campagna con id: " + CampaignId + " non è stata trovata" );
        }
        npc.setCampaign(optionalCampaign.get());
        return npcRepository.save(npc);
    }

    @Override
    public List<NPCDto> getNPCsByCampaign(Long campaignId) {
        List<NPC> npcs = npcRepository.findByCampaignId(campaignId);
        return npcs.stream()
                .map(NPCDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public NPC updateNPC(long id, NPC npcData) throws EntityNotFoundException {
        NPC existingNPC = npcRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("NPC con id: " + id + " non trovato."));

        // Aggiorna solo i campi del NPC senza modificare la campagna associata
        existingNPC.setName(npcData.getName());
        existingNPC.setSurname(npcData.getSurname());
        existingNPC.setDescription(npcData.getDescription());
        existingNPC.setDeath(npcData.isDeath());
        existingNPC.setRace(npcData.getRace());
        existingNPC.setClasse(npcData.getClasse());

        return npcRepository.save(existingNPC);
    }



}
