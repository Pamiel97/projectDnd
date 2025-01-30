package progettino.dnd.projectDnd.dtos;

public class EquipDto {
    private long id;
    private String name;
    private String description;
    private int protect;  // Valore di protezione dell'equipaggiamento
    private int cost;     // Costo dell'equipaggiamento
    private String note;  // Eventuali note aggiuntive

    private BagDto bag;
}
