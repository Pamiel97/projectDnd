package progettino.dnd.projectDnd.dtos;

import java.util.List;

public class SlotDto {
    private long id;
    private int levelSlot;
    private int remainingUse;

    private CharacterPgDto pg;  // DTO per il PG associato a questo slot

    private List<CharmDto> charms;
}
