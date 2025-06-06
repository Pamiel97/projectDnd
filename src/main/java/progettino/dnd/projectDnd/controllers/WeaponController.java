package progettino.dnd.projectDnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progettino.dnd.projectDnd.dtos.PotionDto;
import progettino.dnd.projectDnd.dtos.WeaponDto;
import progettino.dnd.projectDnd.model.entities.Potion;
import progettino.dnd.projectDnd.model.entities.Weapon;
import progettino.dnd.projectDnd.model.exception.EntityNotFoundException;
import progettino.dnd.projectDnd.model.services.abstraction.PotionService;
import progettino.dnd.projectDnd.model.services.abstraction.WeaponService;

import java.util.List;

@RestController
@RequestMapping("/api/weapons")
public class WeaponController {

    private WeaponService weaponService;

    @Autowired
    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @PostMapping("/bag/{bagId}")
    public ResponseEntity<Weapon> createWeapon(@PathVariable long bagId, @RequestBody WeaponDto weaponDto) {
        try {
            Weapon entity = weaponDto.toEntity();
            Weapon createdWeapon = weaponService.createWeapon(bagId, entity);
            return new ResponseEntity<>(createdWeapon, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWeapon(@PathVariable Long id) {
        weaponService.deleteWeapon(id);
        return ResponseEntity.ok("Weapon with ID " + id + " deleted successfully.");
    }

    @GetMapping("/bag/{bagId}")
    public ResponseEntity<List<Weapon>> getWeaponsByBag(@PathVariable Long bagId) {
        List<Weapon> weapons = weaponService.getWeaponsByBag(bagId);
        return ResponseEntity.ok(weapons);
    }
}
