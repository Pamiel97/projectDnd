package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Talent;

public class TalentDto {
    private long id;
    private String name;
    private String description;

    public TalentDto() {
    }

    public TalentDto(long id, String name, String description) {
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

    public static Talent toEntity(TalentDto talentDto) {
        if (talentDto == null) {
            return null;
        }

        Talent talent = new Talent();
        talent.setId(talentDto.getId());
        talent.setName(talentDto.getName());
        talent.setDescription(talentDto.getDescription());

        return talent;
    }

    public static TalentDto fromEntity(Talent talent) {
        if (talent == null) {
            return null;
        }

        TalentDto talentDto = new TalentDto();
        talentDto.setId(talent.getId());
        talentDto.setName(talent.getName());
        talentDto.setDescription(talent.getDescription());

        return talentDto;
    }


}
