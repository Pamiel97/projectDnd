package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.EquipDto;
import progettino.dnd.projectDnd.dtos.PotionDto;
import progettino.dnd.projectDnd.model.entities.Equip;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.EquipService;
import progettino.dnd.projectDnd.model.services.abstraction.PotionService;

@RestController
@RequestMapping("/api/equips")
public class EquipController {
    private EquipService equipService;

    @Autowired
    public EquipController(EquipService equipService) {
        this.equipService = equipService;
    }

    @PostMapping("/bag/{bagId}")
    public ResponseEntity<Equip> createPotion(@PathVariable long bagId, @RequestBody EquipDto equipDto) {
        try {
            Equip entiy = equipDto.toEntity();
            Equip createEquip = equipService.createEquip(bagId, entiy);
            return new ResponseEntity<>(createEquip, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
