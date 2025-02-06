package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.PotionDto;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.PotionService;

@RestController
@RequestMapping("/api/potions")
public class PotionController {

    private  PotionService potionService;

    @Autowired
    public PotionController(PotionService potionService) {
        this.potionService = potionService;
    }

    @PostMapping("/bag/{bagId}")
    public ResponseEntity<Potion> createPotion(@PathVariable long bagId, @RequestBody PotionDto potionDto) {
        try {
            Potion entity = potionDto.toEntity();
            Potion createdPotion = potionService.createPotion(bagId, entity);
            return new ResponseEntity<>(createdPotion, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
