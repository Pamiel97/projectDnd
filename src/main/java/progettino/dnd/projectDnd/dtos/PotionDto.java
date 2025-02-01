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

    private long bagId;  // DTO per la borsa a cui appartiene l'oggetto


    public PotionDto() {
    }

    public PotionDto(long bagId, int cost, String note, int diceAttack, int diceHealth, int dice, String description, String name, long id) {
        this.bagId = bagId;
        this.cost = cost;
        this.note = note;
        this.diceAttack = diceAttack;
        this.diceHealth = diceHealth;
        this.dice = dice;
        this.description = description;
        this.name = name;
        this.id = id;
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

    public long getBagId() {
        return bagId;
    }

    public void setBagId(long bagId) {
        this.bagId = bagId;
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
        potionDto.setBagId(potion.getBag().getId());

        return potionDto;
    }



  //TODO
    public  Potion toEntity() {


        Potion potion = new Potion();
        potion.setId(this.id);
        potion.setName(this.name);
        potion.setDescription(this.description);
        potion.setDice(this.dice);
        potion.setDiceHealt(this.diceHealth);
        potion.setDiceAttack(this.diceAttack);
        potion.setNote(this.note);
        potion.setCost(this.cost);

       //NEL CONTROLLER METTERGLI LA BORSA

        return potion;
    }




}
