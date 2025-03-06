package progettino.dnd.projectDnd.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import progettino.dnd.projectDnd.model.entities.Spell;
import progettino.dnd.projectDnd.model.entities.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SlotDto {
    private long id;
    private int levelSlot;
    private int remainingUse;
    private long characterId;  // DTO per il PG associato a questo slot

    @JsonIgnore
    private List<SpellDto> spells;


    public SlotDto() {
    }

    public SlotDto(long id, int levelSlot, int remainingUse, long characterId, List<SpellDto> spells) {
        this.id = id;
        this.levelSlot = levelSlot;
        this.remainingUse = remainingUse;
        this.characterId = characterId;
        this.spells = spells;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevelSlot() {
        return levelSlot;
    }

    public void setLevelSlot(int levelSlot) {
        this.levelSlot = levelSlot;
    }

    public int getRemainingUse() {
        return remainingUse;
    }

    public void setRemainingUse(int remainingUse) {
        this.remainingUse = remainingUse;
    }

    public long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(long characterId) {
        this.characterId = characterId;
    }

    public List<SpellDto> getSpells() {
        return spells;
    }

    public void setSpells(List<SpellDto> spells) {
        this.spells = spells;
    }

    public static SlotDto fromEntity(Slot slot) {
        SlotDto dto = new SlotDto();
        dto.setId(slot.getId());
        dto.setLevelSlot(slot.getLevelSlot());
        dto.setRemainingUse(slot.getRemainingUse());
        dto.setCharacterId(slot.getPg() != null ? slot.getPg().getId() : 0);
        dto.setSpells(slot.getSpells() != null ? slot.getSpells().stream().map(SpellDto::fromEntity).collect(Collectors.toList()) : new ArrayList<>());
        return dto;
    }


    public Slot toEntity() {
        Slot slot = new Slot();
        slot.setId(this.id);
        slot.setLevelSlot(this.levelSlot);
        slot.setRemainingUse(this.remainingUse);
        slot.setSpells(this.spells != null ? this.spells.stream().map(SpellDto::toEntity).collect(Collectors.toList()) : new ArrayList<>());
        return slot;
    }




//    public static Slot toEntity(SlotDto slotDto) {
//        if (slotDto == null) {
//            return null;
//        }
//
//        Slot slot = new Slot();
//        slot.setId(slotDto.getId());
//        slot.setLevelSlot(slotDto.getLevelSlot());
//        slot.setRemainingUse(slotDto.getRemainingUse());
//
//        // Convertiamo i CharmDto in Charm (relazione Many-to-Many)
//        if (slotDto.getCharms() != null) {
//            List<Spell> spells = slotDto.getCharms().stream()
//                    .map(SpellDto::toEntity)  // Converte ogni CharmDto in Charm
//                    .collect(Collectors.toList());
//            slot.setCharms(spells);  // Impostiamo la lista di Charm
//        }
//
//        return slot;
//    }
//
//    public static SlotDto fromEntity() {
//        if (slot == null) {
//            return null;
//        }
//
//        SlotDto slotDto = new SlotDto();
//        slotDto.setId(slot.getId());
//        slotDto.setLevelSlot(slot.getLevelSlot());
//        slotDto.setRemainingUse(slot.getRemainingUse());
//
//        slotDto.setCharacterId(slot.getPg().getId());
//
//        // Impostiamo la lista di CharmDto (relazione Many-to-Many)
//        if (slot.getCharms() != null) {
//            List<SpellDto> spellDtos = slot.getCharms().stream()
//                    .map(SpellDto::fromEntity)  // Converte ogni Charm in CharmDto
//                    .collect(Collectors.toList());
//            slotDto.setCharms(spellDtos);  // Impostiamo la lista di CharmDto
//        }
//
//        return slotDto;
//    }


}
