package progettino.dnd.projectDnd.dtos;

import java.util.List;

public class BagDto {
    private long id;
    private CharacterPgDto pg;  // DTO per il personaggio associato alla borsa

    private List<PotionDto> potions;  // Lista di pozioni nella borsa
    private List<EquipDto> equips;    // Lista di equipaggiamento nella borsa
    private List<WeaponDto> weapons;  // Lista di armi nella borsa
    private List<ObjectDto> objects;  // Lista di oggetti nella borsa
}
