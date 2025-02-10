package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.MissionDto;
import progettino.dnd.projectDnd.model.entities.Mission;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.MissionService;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
public class MissionController {
    private MissionService missionService;

    @Autowired
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping
    public ResponseEntity<Mission> createMission(@RequestBody MissionDto mission, @RequestParam long diaryId) {
        Mission createdMission = null;
        try {
            Mission missionEntity = mission.toEntity();
            createdMission = missionService.createMission(missionEntity, diaryId);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(createdMission);
    }

    //UTENTE PRIMA SI CREA NPC POI MISSIONE E POI SE VUOLE LI COLLEGA
    @PostMapping("/{missionId}/link-npcs")
    public ResponseEntity<MissionDto> linkNPCsToMission(@PathVariable long missionId, @RequestBody List<Long> npcIds) {
        Mission updatedMission = missionService.linkNPCsToMission(missionId, npcIds);
        MissionDto missione = MissionDto.fromEntity(updatedMission);
        return ResponseEntity.ok(missione);
    }

    @GetMapping("/completed/{diaryId}")
    public ResponseEntity<List<Mission>> getCompletedMissions(@PathVariable Long diaryId) {
        List<Mission> missions = missionService.getCompletedMissions(diaryId);
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/incomplete/{diaryId}")
    public ResponseEntity<List<Mission>> getIncompleteMissions(@PathVariable Long diaryId) {
        List<Mission> missions = missionService.getIncompleteMissions(diaryId);
        return ResponseEntity.ok(missions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mission> updateMission(
            @PathVariable long id,
            @RequestBody MissionDto missionDto) {

        try {
            Mission missionData = missionDto.toEntity();
            Mission updatedMission = missionService.updateMission(id, missionData);
            return ResponseEntity.ok(updatedMission);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
