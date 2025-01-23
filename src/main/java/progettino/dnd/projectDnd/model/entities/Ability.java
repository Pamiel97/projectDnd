package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "abilities")
public class Ability {
    //tipo acrobazia ecc
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name; //enum
    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

}
