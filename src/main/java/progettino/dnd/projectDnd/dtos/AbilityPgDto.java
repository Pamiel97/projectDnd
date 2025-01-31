package progettino.dnd.projectDnd.dtos;

public class AbilityPgDto {
    private long id;
    private boolean competence;
    private int point;
    private AbilityDto abilityDto;  // ID dell'abilità associata
    private CharacterPgDto characterPgDto;       // ID del personaggio associato

    public AbilityPgDto() {
    }

    public AbilityPgDto(long id, boolean competence, int point, AbilityDto abilityDto, CharacterPgDto characterPgDto) {
        this.id = id;
        this.competence = competence;
        this.point = point;
        this.abilityDto = abilityDto;
        this.characterPgDto = characterPgDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCompetence() {
        return competence;
    }

    public void setCompetence(boolean competence) {
        this.competence = competence;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public AbilityDto getAbilityDto() {
        return abilityDto;
    }

    public void setAbilityDto(AbilityDto abilityDto) {
        this.abilityDto = abilityDto;
    }

    public CharacterPgDto getCharacterPgDto() {
        return characterPgDto;
    }

    public void setCharacterPgDto(CharacterPgDto characterPgDto) {
        this.characterPgDto = characterPgDto;
    }
}
