package progettino.dnd.projectDnd.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "abilities_pg")
public class AbilityPg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean competence;
    private int point;


    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ability_id")
    @JsonManagedReference// Relazione molti-a-uno con Ability
    private Ability ability;

    @JsonIgnore
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pg_id")// Relazione molti-a-uno con CharacterPg
    private CharacterPg pg;




    public AbilityPg() {
    }

    public AbilityPg(long id, boolean competence, int point, Ability ability, CharacterPg pg) {
        this.id = id;
        this.competence = competence;
        this.point = point;
        this.ability = ability;
        this.pg = pg;
    }

    public CharacterPg getPg() {
        return pg;
    }

    public void setPg(CharacterPg pg) {
        this.pg = pg;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isCompetence() {
        return competence;
    }

    public void setCompetence(boolean competence) {
        this.competence = competence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
