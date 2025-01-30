package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "slots")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "level_slot")
    private int levelSlot;
    @Column(name = "remaining_use")
    private int remainingUse;


    @ManyToOne
    @JoinColumn(name = "pg_id", nullable = false)
    private CharacterPg pg;  // Il PG a cui appartiene questo slot

    @ManyToMany
    @JoinTable(
            name = "slot_charms",
            joinColumns = @JoinColumn(name = "slot_id"),
            inverseJoinColumns = @JoinColumn(name = "charm_id")
    )
    private List<Charm> charms;  // Lista di incantesimi nello slot
    //tabella con id slot 1 ha incantesimo 2/3/4 ecc


    public Slot() {
    }

    public Slot(long id, int levelSlot, int remainingUse, CharacterPg pg, List<Charm> charms) {
        this.id = id;
        this.levelSlot = levelSlot;
        this.remainingUse = remainingUse;
        this.pg = pg;
        this.charms = charms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevelSlot() {
        return levelSlot;
    }

    public void setLevelSlot(int levelSlot) {
        this.levelSlot = levelSlot;
    }

    public int getRemainingUse() {
        return remainingUse;
    }

    public void setRemainingUse(int remainingUse) {
        this.remainingUse = remainingUse;
    }

    public CharacterPg getPg() {
        return pg;
    }

    public void setPg(CharacterPg pg) {
        this.pg = pg;
    }

    public List<Charm> getCharms() {
        return charms;
    }

    public void setCharms(List<Charm> charms) {
        this.charms = charms;
    }
}
