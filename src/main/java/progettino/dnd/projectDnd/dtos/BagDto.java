package progettino.dnd.projectDnd.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.CharacterPg;

import java.util.List;
import java.util.stream.Collectors;

public class BagDto {
    private long id;

    @JsonIgnore
    @JsonManagedReference
    private long pgId;

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

    public BagDto(long id, long pgId, List<PotionDto> potions, List<EquipDto> equips, List<WeaponDto> weapons, List<ObjectDto> objects) {
        this.id = id;
        this.pgId = pgId;
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

    public long getPgId() {
        return pgId;
    }

    public void setPgId(long pgId) {
        this.pgId = pgId;
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

    public static BagDto fromEntity(Bag bag) {
        if (bag == null) {
            return null;
        }

        BagDto dto = new BagDto();
        dto.setId(bag.getId());
        dto.setPgId(bag.getPg().getId());
        dto.setPotions(bag.getPotions().stream().map(PotionDto::fromEntity).collect(Collectors.toList()));
        dto.setEquips(bag.getEquips().stream().map(EquipDto::fromEntity).collect(Collectors.toList()));
        dto.setWeapons(bag.getWeapons().stream().map(WeaponDto::fromEntity).collect(Collectors.toList()));
        dto.setObjects(bag.getObjects().stream().map(ObjectDto::fromEntity).collect(Collectors.toList()));

        return dto;
    }

    //TODO
    public Bag toEntity() {
        Bag bag = new Bag();
        bag.setId(this.id);
        //CONTROLLER PER PG
        //PENSARE ALLE POZIONI ECC

        return bag;
    }
}

