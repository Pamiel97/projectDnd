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
    private int modificatore;

    @ManyToOne
    @JoinColumn(name = "pg_id")
    private CharacterPg pg;


    public TiriSalvezza() {
    }

    public TiriSalvezza(long id, Type type, int point, int modificatore, CharacterPg pg) {
        this.id = id;
        this.type = type;
        this.point = point;
        this.modificatore = modificatore;
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

    public int getModificatore() {
        return modificatore;
    }

    public void setModificatore(int modificatore) {
        this.modificatore = modificatore;
    }

    public CharacterPg getPg() {
        return pg;
    }

    public void setPg(CharacterPg pg) {
        this.pg = pg;
    }
}
