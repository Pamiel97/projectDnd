package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tiri_salvezza")
public class TiriSalvezza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int point;
    private boolean competenza;

    @ManyToOne
    @JoinColumn(name = "pg_id")
    private CharacterPg pg;


    public TiriSalvezza() {
    }

    public TiriSalvezza(long id, Type type, int point, boolean competenza, CharacterPg pg) {
        this.id = id;
        this.type = type;
        this.point = point;
        this.competenza = competenza;
        this.pg = pg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean getCompetenza() {
        return competenza;
    }

    public void setCompetenza(boolean competenza) {
        this.competenza = competenza;
    }

    public CharacterPg getPg() {
        return pg;
    }

    public void setPg(CharacterPg pg) {
        this.pg = pg;
    }
}
