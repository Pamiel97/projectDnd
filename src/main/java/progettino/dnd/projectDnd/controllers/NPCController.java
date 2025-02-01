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
//    private NPCService npcService;
//    private NPCMapper npcMapper;
//
//    @Autowired
//    public NPCController(NPCService npcService, NPCMapper npcMapper) {
//        this.npcService = npcService;
//        this.npcMapper = npcMapper;
//    }
//
//
//
//    @PostMapping
//    public ResponseEntity<NPCDto> createNPC(@RequestBody NPCDto npcDto) {
//        NPC npc = npcMapper.toEntity(npcDto);
//        try {
//            NPC savedNpc = npcService.createNPC(npc, npcDto.getCampaignId());
//            NPCDto savedDto = npcMapper.toDto(savedNpc);
//            return ResponseEntity.ok(savedDto);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
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

//    @PostMapping
//    public ResponseEntity<NPCDto> createNPC(@RequestBody NPCDto npcDto, @RequestParam long campaignId) {
//        NPC npc = npcMapper.toEntity(npcDto);
//        try {
//            NPC savedNpc = npcService.createNPC(npc, campaignId);
//            NPCDto savedDto = npcMapper.toDto(savedNpc);
//            return ResponseEntity.ok(savedDto);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }


//    @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping
//    public ResponseEntity<?> createNPC(@RequestBody NPCDto npcDto, @RequestParam long id) {
//        NPC npc = npcDto.toCharacter();
//        try {
//            NPC saved = npcService.createNPC(npc, id);
//            return ResponseEntity.ok(saved);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campagna non trovata con ID: " + id);
//        }
//    }
}
