package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "charms")
public class Charm {
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


    @ManyToMany(mappedBy = "charms")
    private List<Slot> slots;  // Lista di slot che contengono questo incantesimo
    
}
