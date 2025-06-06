package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Ability;
import progettino.dnd.projectDnd.model.entities.Type;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public static AbilityDto fromEntity(Ability ability) {
        if (ability == null) {
            return null;
        }

        AbilityDto dto = new AbilityDto();
        dto.setId(ability.getId());
        dto.setName(ability.getName());
        dto.setDescription(ability.getDescription());
        dto.setType(ability.getType());

        return dto;
    }

    public Ability toEntity() {
        Ability ability = new Ability();
        ability.setId(this.id);
        ability.setName(this.name);
        ability.setDescription(this.description);
        ability.setType(this.type);

        return ability;
    }
}
