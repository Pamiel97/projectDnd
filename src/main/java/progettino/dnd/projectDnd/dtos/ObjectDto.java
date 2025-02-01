package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Bag;

public class ObjectDto {
    private long id;
    private String name;       // Nome dell'oggetto (ad esempio, "Dado della Fortuna")
    private String description; // Descrizione dell'oggetto
    private String note;        // Eventuali note aggiuntive
    private String effect;      // Effetto dell'oggetto (ad esempio, "Causa 1d6 danni")
    private String rarity;      // Rarità dell'oggetto (ad esempio, "Comune", "Rara", ecc.)
    private String cost;        // Costo dell'oggetto (potrebbe essere in monete d'oro, ecc.)
    private int dice;           // Numero di dadi utilizzati per determinare l'effetto
    private int attack;         // Valore di attacco associato all'oggetto
    private int health;         // Valore di salute o cura associato all'oggetto

    private long bagId;


    public ObjectDto() {
    }

    public ObjectDto(long id, String name, String description, String note, String effect, String rarity, String cost, int dice, int attack, int health, long bagId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.note = note;
        this.effect = effect;
        this.rarity = rarity;
        this.cost = cost;
        this.dice = dice;
        this.attack = attack;
        this.health = health;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public long getBagId() {
        return bagId;
    }

    public void setBagId(long bagId) {
        this.bagId = bagId;
    }


    public static ObjectDto fromEntity(progettino.dnd.projectDnd.model.entities.Object object) {
        if (object == null) {
            return null;
        }

        ObjectDto objectDto = new ObjectDto();
        objectDto.setId(object.getId());
        objectDto.setName(object.getName());
        objectDto.setDescription(object.getDescription());
        objectDto.setNote(object.getNote());
        objectDto.setEffect(object.getEffect());
        objectDto.setRarity(object.getRarity());
        objectDto.setCost(object.getCost());
        objectDto.setDice(object.getDice());
        objectDto.setAttack(object.getAttack());
        objectDto.setHealth(object.getHealth());
        objectDto.setBagId(object.getBag().getId());

        return objectDto;
    }







  //TODO
    public Object toEntity() {

        progettino.dnd.projectDnd.model.entities.Object object = new progettino.dnd.projectDnd.model.entities.Object();
        object.setId(this.id);
        object.setName(this.name);
        object.setDescription(this.description);
        object.setNote(this.note);
        object.setEffect(this.effect);
        object.setRarity(this.rarity);
        object.setCost(this.cost);
        object.setDice(this.dice);
        object.setAttack(this.attack);
        object.setHealth(this.health);

        //trovare la bag con id nel controller hehe

        return object;
    }




}
