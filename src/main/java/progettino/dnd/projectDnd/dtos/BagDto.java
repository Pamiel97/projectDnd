package progettino.dnd.projectDnd.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.CharacterPg;

import java.util.List;
import java.util.stream.Collectors;

public class BagDto {
    private long id;
    @JsonBackReference
    private CharacterPgDto pg;  // DTO per il personaggio associato alla borsa

    private List<PotionDto> potions;  // Lista di pozioni nella borsa
    private List<EquipDto> equips;    // Lista di equipaggiamento nella borsa
    private List<WeaponDto> weapons;  // Lista di armi nella borsa
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

    public static BagDto fromEntity(Bag bag) {
        if (bag == null) {
            return null;
        }

        BagDto dto = new BagDto();
        dto.setId(bag.getId());
        dto.setPg(CharacterPgDto.fromEntity(bag.getPg()));
        dto.setPotions(bag.getPotions().stream().map(PotionDto::fromEntity).collect(Collectors.toList()));
        dto.setEquips(bag.getEquips().stream().map(EquipDto::fromEntity).collect(Collectors.toList()));
        dto.setWeapons(bag.getWeapons().stream().map(WeaponDto::fromEntity).collect(Collectors.toList()));
        dto.setObjects(bag.getObjects().stream().map(ObjectDto::fromEntity).collect(Collectors.toList()));

        return dto;
    }

    // Convert from DTO to Entity
    public Bag toEntity(CharacterPg characterPg) {
        Bag bag = new Bag();
        bag.setId(this.id);
        bag.setPg(characterPg);
        return bag;
    }

}
