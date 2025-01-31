package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Type;

public class AbilityDto {
    private long id;
    private String name; // enum name as a String
    private String description;
    private Type type; // enum Type


    public AbilityDto() {
    }

    public AbilityDto(long id, String name, String description, Type type) {
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
