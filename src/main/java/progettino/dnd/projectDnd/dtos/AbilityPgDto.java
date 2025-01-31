package progettino.dnd.projectDnd.dtos;

public class AbilityPgDto {
    private long id;
    private boolean competence;
    private int point;
    private long abilityId;  // Solo l'ID dell'abilità, non l'oggetto completo
    private long pgId;  //

    public AbilityPgDto() {
    }

    public AbilityPgDto(long id, boolean competence, int point, long abilityId, long pgId) {
        this.id = id;
        this.competence = competence;
        this.point = point;
        this.abilityId = abilityId;
        this.pgId = pgId;
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

    public long getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(long abilityId) {
        this.abilityId = abilityId;
    }

    public long getPgId() {
        return pgId;
    }

    public void setPgId(long pgId) {
        this.pgId = pgId;
    }
}
