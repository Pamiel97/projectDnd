package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Charm;
import progettino.dnd.projectDnd.model.entities.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SlotDto {
    private long id;
    private int levelSlot;
    private int remainingUse;

    private long characterId;  // DTO per il PG associato a questo slot

    private List<CharmDto> charms;


    public SlotDto() {
    }

    public SlotDto(List<CharmDto> charms, long characterId, int remainingUse, int levelSlot, long id) {
        this.charms = charms;
        this.characterId = characterId;
        this.remainingUse = remainingUse;
        this.levelSlot = levelSlot;
        this.id = id;
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

    public List<CharmDto> getCharms() {
        return charms;
    }

    public void setCharms(List<CharmDto> charms) {
        this.charms = charms;
    }

    public static Slot toEntity(SlotDto slotDto) {
        if (slotDto == null) {
            return null;
        }

        Slot slot = new Slot();
        slot.setId(slotDto.getId());
        slot.setLevelSlot(slotDto.getLevelSlot());
        slot.setRemainingUse(slotDto.getRemainingUse());

        // Convertiamo i CharmDto in Charm (relazione Many-to-Many)
        if (slotDto.getCharms() != null) {
            List<Charm> charms = slotDto.getCharms().stream()
                    .map(CharmDto::toEntity)  // Converte ogni CharmDto in Charm
                    .collect(Collectors.toList());
            slot.setCharms(charms);  // Impostiamo la lista di Charm
        }

        return slot;
    }

    public static SlotDto fromEntity(Slot slot) {
        if (slot == null) {
            return null;
        }

        SlotDto slotDto = new SlotDto();
        slotDto.setId(slot.getId());
        slotDto.setLevelSlot(slot.getLevelSlot());
        slotDto.setRemainingUse(slot.getRemainingUse());

        slotDto.setCharacterId(slot.getPg().getId());

        // Impostiamo la lista di CharmDto (relazione Many-to-Many)
        if (slot.getCharms() != null) {
            List<CharmDto> charmDtos = slot.getCharms().stream()
                    .map(CharmDto::fromEntity)  // Converte ogni Charm in CharmDto
                    .collect(Collectors.toList());
            slotDto.setCharms(charmDtos);  // Impostiamo la lista di CharmDto
        }

        return slotDto;
    }


}
