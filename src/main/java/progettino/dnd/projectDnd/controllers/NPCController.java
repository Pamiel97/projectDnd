package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.NPCDto;
import progettino.dnd.projectDnd.model.entities.Campaign;
import progettino.dnd.projectDnd.model.entities.NPC;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.repositories.CampaignRepository;
import progettino.dnd.projectDnd.model.services.abstraction.NPCService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/npc")
public class NPCController {
    private NPCService npcService;


    @Autowired
    public NPCController(NPCService npcService) {
        this.npcService = npcService;

    }



    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<NPCDto>> getNPCsByCampaign(@PathVariable Long campaignId) {
        List<NPCDto> npcDtos = npcService.getNPCsByCampaign(campaignId);
        return new ResponseEntity<>(npcDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NPCDto> createNPC(@RequestBody NPCDto npcDto, @RequestParam long campaignId) {
        NPC npc = npcDto.toEntity();
        try {
            NPC savedNpc = npcService.createNPC(npc, campaignId);
            NPCDto savedDto = NPCDto.fromEntity(savedNpc);
            return ResponseEntity.ok(savedDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<NPC> updateNPC(
            @PathVariable long id,
            @RequestBody NPCDto npcDto) {

        try {
            NPC npcData = npcDto.toEntity();
            NPC updatedNPC = npcService.updateNPC(id, npcData);
            return ResponseEntity.ok(updatedNPC);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
