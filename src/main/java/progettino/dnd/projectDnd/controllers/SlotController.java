package progettino.dnd.projectDnd.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.SlotDto;
import progettino.dnd.projectDnd.model.entities.Slot;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.SlotService;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
@Validated
public class SlotController {


    private SlotService slotService;

    public SlotController (SlotService slotService){
        this.slotService = slotService;
    }


    @PostMapping("/{characterId}")
    public ResponseEntity<?> createSlot(
            @RequestBody SlotDto slotDto,
            @PathVariable long characterId) {

        try {
            Slot slot = slotDto.toEntity();
            Slot createdSlot = slotService.createSlot(slot, characterId);
            return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/character/{characterId}")
    public ResponseEntity<List<SlotDto>> getSlotsByCharacter(@PathVariable Long characterId) {
        List<SlotDto> slotDtos = slotService.getSlotsByCharacter(characterId);
        return new ResponseEntity<>(slotDtos, HttpStatus.OK);
    }
}
