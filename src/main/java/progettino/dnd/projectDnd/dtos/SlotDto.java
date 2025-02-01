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

    private CharacterPgDto pg;  // DTO per il PG associato a questo slot

    private List<CharmDto> charms;


    public SlotDto() {
    }

    public SlotDto(long id, int levelSlot, int remainingUse, CharacterPgDto pg, List<CharmDto> charms) {
        this.id = id;
        this.levelSlot = levelSlot;
        this.remainingUse = remainingUse;
        this.pg = pg;
        this.charms = charms;
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

    public CharacterPgDto getPg() {
        return pg;
    }

    public void setPg(CharacterPgDto pg) {
        this.pg = pg;
    }

    public List<CharmDto> getCharms() {
        return charms;
    }

    public void setCharms(List<CharmDto> charms) {
        this.charms = charms;
    }

    public static Slot toEntity(SlotDto slotDto, CharacterPg pg) {
        if (slotDto == null) {
            return null;
        }

        Slot slot = new Slot();
        slot.setId(slotDto.getId());
        slot.setLevelSlot(slotDto.getLevelSlot());
        slot.setRemainingUse(slotDto.getRemainingUse());

        // Impostiamo la relazione con il PG usando l'oggetto CharacterPg passato
        slot.setPg(pg);

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

        // Impostiamo il CharacterPgDto (associato all'oggetto Slot)
        if (slot.getPg() != null) {
            CharacterPgDto pgDto = CharacterPgDto.fromEntity(slot.getPg());  // Converte CharacterPg in CharacterPgDto
            slotDto.setPg(pgDto);  // Impostiamo CharacterPgDto nel DTO dello slot
        }

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
