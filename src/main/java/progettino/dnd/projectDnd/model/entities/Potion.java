package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "potions")
public class Potion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int dice;
    @Column(name = "dice_healt")
    private int diceHealt;
    @Column(name = "dice_attack")
    private int diceAttack;
    private String note;

    private int cost;

    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;


    public Potion() {
    }

    public Potion(long id, String name, String description, int dice, int diceHealt, int diceAttack, String note, int cost, Bag bag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dice = dice;
        this.diceHealt = diceHealt;
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

    public int getDiceHealt() {
        return diceHealt;
    }

    public void setDiceHealt(int diceHealt) {
        this.diceHealt = diceHealt;
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

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
