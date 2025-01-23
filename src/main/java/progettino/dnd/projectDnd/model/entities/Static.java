package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "statics")
public class Static {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int point;
    private int modificatore;

    @ManyToOne
    @JoinColumn(name = "pg_id")
    private CharacterPg pg;
}
