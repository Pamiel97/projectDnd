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

}
