package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "objects")
public class Object {
    //se voglio fare cosette carine (creare un dice)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String note;
    private String effect;
    private String rarity;
    private String cost;
    private int dice;
    private int attack;
    private int health;

    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;


    public Object() {
    }

    public Object(long id, String name, String description, String note, String effect, String rarity, String cost, int dice, int attack, int health, Bag bag) {
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

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
