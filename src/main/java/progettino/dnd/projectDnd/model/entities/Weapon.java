package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "weapons")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @Column(name = "magic_effect")
    private String magicEffect;
    private int dice;
    @Column(name = "dice_attack")
    private int diceAttack;
    private String note;
    private int cost;

    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;
}
