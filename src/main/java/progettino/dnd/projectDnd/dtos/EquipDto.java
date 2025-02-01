package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Equip;

public class EquipDto {
    private long id;
    private String name;
    private String description;
    private int protect;  // Valore di protezione dell'equipaggiamento
    private int cost;     // Costo dell'equipaggiamento
    private String note;  // Eventuali note aggiuntive

    private long bagId;


    public EquipDto() {

    }

    public EquipDto(long id, String name, String description, int protect, int cost, String note, long bagId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.protect = protect;
        this.cost = cost;
        this.note = note;
        this.bagId = bagId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProtect() {
        return protect;
    }

    public void setProtect(int protect) {
        this.protect = protect;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getBagId() {
        return bagId;
    }

    public void setBagId(long bagId) {
        this.bagId = bagId;
    }

    public static EquipDto fromEntity(Equip equip) {
        if (equip == null) {
            return null;
        }

        EquipDto equipDto = new EquipDto();
        equipDto.setId(equip.getId());
        equipDto.setName(equip.getName());
        equipDto.setDescription(equip.getDescription());
        equipDto.setProtect(equip.getProtect());
        equipDto.setCost(equip.getCost());
        equipDto.setNote(equip.getNote());
        equipDto.setBagId(equip.getBag().getId());

        return equipDto;
    }

    // Metodi di Conversione da DTO a Entity //TODO
    public static Equip toEntity(EquipDto equipDto) {
        if (equipDto == null) {
            return null;
        }

        Equip equip = new Equip();
        equip.setId(equipDto.getId());
        equip.setName(equipDto.getName());
        equip.setDescription(equipDto.getDescription());
        equip.setProtect(equipDto.getProtect());
        equip.setCost(equipDto.getCost());
        equip.setNote(equipDto.getNote());

       //PER BORSA FIND BY ID

        return equip;
    }
}
