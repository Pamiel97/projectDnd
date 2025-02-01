package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Bag;
import progettino.dnd.projectDnd.model.entities.Potion;

public class PotionDto {
    private long id;
    private String name;
    private String description;
    private int dice;  // Dadi utilizzati per il calcolo dell'effetto o danno
    private int diceHealth;  // Dadi per la salute, se applicabile
    private int diceAttack;  // Dadi per l'attacco, se applicabile
    private String note;  // Eventuali note aggiuntive
    private int cost;  // Costo dell'oggetto

    private BagDto bag;  // DTO per la borsa a cui appartiene l'oggetto


    public PotionDto() {
    }

    public PotionDto(long id, String name, String description, int dice, int diceHealth, int diceAttack, String note, int cost, BagDto bag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dice = dice;
        this.diceHealth = diceHealth;
        this.diceAttack = diceAttack;
        this.note = note;
        this.cost = cost;
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

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getDiceHealth() {
        return diceHealth;
    }

    public void setDiceHealth(int diceHealth) {
        this.diceHealth = diceHealth;
    }

    public int getDiceAttack() {
        return diceAttack;
    }

    public void setDiceAttack(int diceAttack) {
        this.diceAttack = diceAttack;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public BagDto getBag() {
        return bag;
    }

    public void setBag(BagDto bag) {
        this.bag = bag;
    }

    public static Potion toEntity(PotionDto potionDto, Bag bag) {
        if (potionDto == null) {
            return null;
        }

        Potion potion = new Potion();
        potion.setId(potionDto.getId());
        potion.setName(potionDto.getName());
        potion.setDescription(potionDto.getDescription());
        potion.setDice(potionDto.getDice());
        potion.setDiceHealt(potionDto.getDiceHealth());
        potion.setDiceAttack(potionDto.getDiceAttack());
        potion.setNote(potionDto.getNote());
        potion.setCost(potionDto.getCost());

        // Impostiamo la relazione con Bag usando l'oggetto Bag passato
        potion.setBag(bag);

        return potion;
    }

    public static PotionDto fromEntity(Potion potion) {
        if (potion == null) {
            return null;
        }

        PotionDto potionDto = new PotionDto();
        potionDto.setId(potion.getId());
        potionDto.setName(potion.getName());
        potionDto.setDescription(potion.getDescription());
        potionDto.setDice(potion.getDice());
        potionDto.setDiceHealth(potion.getDiceHealt());
        potionDto.setDiceAttack(potion.getDiceAttack());
        potionDto.setNote(potion.getNote());
        potionDto.setCost(potion.getCost());

        // Impostiamo il BagDto (associato all'oggetto Potion)
        if (potion.getBag() != null) {
            BagDto bagDto = BagDto.fromEntity(potion.getBag()); // Convertiamo Bag in BagDto
            potionDto.setBag(bagDto);  // Impostiamo BagDto nel DTO della potion
        }

        return potionDto;
    }


}
