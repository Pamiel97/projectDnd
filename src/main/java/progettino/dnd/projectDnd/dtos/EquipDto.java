package progettino.dnd.projectDnd.dtos;

public class EquipDto {
    private long id;
    private String name;
    private String description;
    private int protect;  // Valore di protezione dell'equipaggiamento
    private int cost;     // Costo dell'equipaggiamento
    private String note;  // Eventuali note aggiuntive

    private BagDto bag;


    public EquipDto() {

    }

    public EquipDto(long id, String name, String description, int protect, int cost, String note, BagDto bag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.protect = protect;
        this.cost = cost;
        this.note = note;
        this.bag = bag;
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

    public BagDto getBag() {
        return bag;
    }

    public void setBag(BagDto bag) {
        this.bag = bag;
    }
}
