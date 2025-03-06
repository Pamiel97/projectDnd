package progettino.dnd.projectDnd.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "spells")
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Column(name = "action_time")
    private String actionTime;
    private int gittate;
    private int duration;
    private int dice;
    private int hitDice;
    private int healthDice;
    private String component;
    private boolean preparate;
    @Column(name = "min_level")
    private int minLevel;
    @Enumerated(EnumType.STRING)
    private Type type;


    @JsonIgnore
    @ManyToMany(mappedBy = "spells")
    private List<Slot> slots;  // Lista di slot che contengono questo incantesimo


    public Spell() {
    }

    public Spell(long id, String name, String description, String actionTime, int gittate, int duration, int dice, int hitDice, int healthDice, String component, boolean preparate, int minLevel, Type type, List<Slot> slots) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.actionTime = actionTime;
        this.gittate = gittate;
        this.duration = duration;
        this.dice = dice;
        this.hitDice = hitDice;
        this.healthDice = healthDice;
        this.component = component;
        this.preparate = preparate;
        this.minLevel = minLevel;
        this.type = type;
        this.slots = slots;
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

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public int getGittate() {
        return gittate;
    }

    public void setGittate(int gittate) {
        this.gittate = gittate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public int getHealthDice() {
        return healthDice;
    }

    public void setHealthDice(int healthDice) {
        this.healthDice = healthDice;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public boolean isPreparate() {
        return preparate;
    }

    public void setPreparate(boolean preparate) {
        this.preparate = preparate;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
