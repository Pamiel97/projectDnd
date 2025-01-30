package progettino.dnd.projectDnd.model.entities;

import jakarta.persistence.*;
//COMMENTONO//PARTE2
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

    public Ability() {
    }

    public Ability(long id, String name, String description, Type type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
