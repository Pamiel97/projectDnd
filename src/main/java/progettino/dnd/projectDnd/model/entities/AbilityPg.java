package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "abilities_pg")
public class AbilityPg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean competence;
    private int point;

    @ManyToOne
    @JoinColumn(name = "ability_id")  // Relazione molti-a-uno con Ability
    private Ability ability;

    @ManyToOne
    @JoinColumn(name = "pg_id")  // Relazione molti-a-uno con CharacterPg
    private CharacterPg pg;



}
