package progettino.dnd.projectDnd.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class BagDto {
    private long id;

    @JsonIgnore
    @JsonManagedReference
    private CharacterPgDto pg;  // DTO per il personaggio associato alla borsa

    @JsonIgnore
    private List<PotionDto> potions;
    @JsonIgnore// Lista di pozioni nella borsa
    private List<EquipDto> equips;
    @JsonIgnore// Lista di equipaggiamento nella borsa
    private List<WeaponDto> weapons;
    @JsonIgnore// Lista di armi nella borsa
    private List<ObjectDto> objects;  // Lista di oggetti nella borsa


    public BagDto() {
    }

    public BagDto(long id, CharacterPgDto pg, List<PotionDto> potions, List<EquipDto> equips, List<WeaponDto> weapons, List<ObjectDto> objects) {
        this.id = id;
        this.pg = pg;
        this.potions = potions;
        this.equips = equips;
        this.weapons = weapons;
        this.objects = objects;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CharacterPgDto getPg() {
        return pg;
    }

    public void setPg(CharacterPgDto pg) {
        this.pg = pg;
    }

    public List<PotionDto> getPotions() {
        return potions;
    }

    public void setPotions(List<PotionDto> potions) {
        this.potions = potions;
    }

    public List<EquipDto> getEquips() {
        return equips;
    }

    public void setEquips(List<EquipDto> equips) {
        this.equips = equips;
    }

    public List<WeaponDto> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<WeaponDto> weapons) {
        this.weapons = weapons;
    }

    public List<ObjectDto> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectDto> objects) {
        this.objects = objects;
    }
}
