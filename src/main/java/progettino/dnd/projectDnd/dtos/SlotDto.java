package progettino.dnd.projectDnd.dtos;

import java.util.List;

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
}
