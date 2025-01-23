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

}
