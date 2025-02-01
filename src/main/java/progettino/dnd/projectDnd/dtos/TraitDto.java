package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Trait;

public class TraitDto {
    private long id;
    private String name;
    private String description;

    public TraitDto() {
    }

    public TraitDto(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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


    public static TraitDto fromEntity(Trait trait) {
        if (trait == null) {
            return null;
        }

        TraitDto traitDto = new TraitDto();
        traitDto.setId(trait.getId());
        traitDto.setName(trait.getName());
        traitDto.setDescription(trait.getDescription());

        return traitDto;
    }

    public  Trait toEntity() {


        Trait trait = new Trait();
        trait.setId(this.id);
        trait.setName(this.name);
        trait.setDescription(this.description);

        return trait;
    }

}
