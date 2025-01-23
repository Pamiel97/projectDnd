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


}
