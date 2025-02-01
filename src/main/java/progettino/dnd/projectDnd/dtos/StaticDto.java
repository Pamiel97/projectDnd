package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.Static;
import progettino.dnd.projectDnd.model.entities.Type;

public class StaticDto {
    private long id;
    private Type type;
    private int point;
    private int modificatore;
    private long pgId; // ID del Personaggio (CharacterPg) associato

    public StaticDto() {
    }

    public StaticDto(long id, Type type, int point, int modificatore, long pgId) {
        this.id = id;
        this.type = type;
        this.point = point;
        this.modificatore = modificatore;
        this.pgId = pgId;
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

    public long getPgId() {
        return pgId;
    }

    public void setPgId(long pgId) {
        this.pgId = pgId;
    }

    public static Static toEntity(StaticDto staticDto, CharacterPg pg) {
        if (staticDto == null) {
            return null;
        }

        Static staticEntity = new Static();
        staticEntity.setId(staticDto.getId());
        staticEntity.setType(staticDto.getType());
        staticEntity.setPoint(staticDto.getPoint());
        staticEntity.setModificatore(staticDto.getModificatore());

        // Impostiamo la relazione con il PG usando l'oggetto CharacterPg passato
        staticEntity.setPg(pg);

        return staticEntity;
    }

    public static StaticDto fromEntity(Static staticEntity) {
        if (staticEntity == null) {
            return null;
        }

        StaticDto staticDto = new StaticDto();
        staticDto.setId(staticEntity.getId());
        staticDto.setType(staticEntity.getType());
        staticDto.setPoint(staticEntity.getPoint());
        staticDto.setModificatore(staticEntity.getModificatore());

        // Impostiamo l'ID del PG associato a questa entità Static
        if (staticEntity.getPg() != null) {
            staticDto.setPgId(staticEntity.getPg().getId());
        }

        return staticDto;
    }


}
