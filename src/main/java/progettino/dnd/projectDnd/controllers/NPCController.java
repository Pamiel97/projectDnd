package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.NPCDto;
import progettino.dnd.projectDnd.model.entities.NPC;
import progettino.dnd.projectDnd.model.entities.User;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.NPCService;

import java.util.List;
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



//    @GetMapping("/campaign/{campaignId}")
//    public ResponseEntity<List<NPCDto>> getNPCsByCampaign(@PathVariable long campaignId) {
//        try {
//            List<NPC> npcs = npcService.getNPCsByCampaignId(campaignId);
//
//            List<NPCDto> npcDtos = npcs.stream()
//                    .map(npcMapper::toDto)
//                    .collect(Collectors.toList());
//
//            return ResponseEntity.ok(npcDtos);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }

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


}
