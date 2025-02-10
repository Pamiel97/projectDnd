package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.ObjectDto;
import progettino.dnd.projectDnd.dtos.PotionDto;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.ObjectService;
import progettino.dnd.projectDnd.model.services.abstraction.PotionService;
import progettino.dnd.projectDnd.model.services.implementation.ObjectJpa;

import java.util.List;

public class ObjectController {
    private ObjectService objectService;

    @Autowired
    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }




    @PostMapping("/bag/{bagId}")
    public ResponseEntity<Object> createObject(@PathVariable long bagId, @RequestBody ObjectDto objectDto) {
        try {
            progettino.dnd.projectDnd.model.entities.Object entity = objectDto.toEntity();
            progettino.dnd.projectDnd.model.entities.Object createdO = objectService.createObject(bagId, entity);
            return new ResponseEntity<>(createdO, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGameObject(@PathVariable Long id) {
        objectService.deleteObject(id);
        return ResponseEntity.ok("GameObject with ID " + id + " deleted successfully.");
    }

    @GetMapping("/bag/{bagId}")
    public ResponseEntity<List<progettino.dnd.projectDnd.model.entities.Object>> getObjectsByBag(@PathVariable Long bagId) {
        List<progettino.dnd.projectDnd.model.entities.Object> objects = objectService.getObjectsByBag(bagId);
        return ResponseEntity.ok(objects);
    }
}
