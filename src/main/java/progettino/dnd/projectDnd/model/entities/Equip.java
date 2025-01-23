package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "equips")
public class Equip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int protect;
    private int cost;
    private String note;


    @ManyToOne
    @JoinColumn(name = "bag_id")
    private Bag bag;
}
