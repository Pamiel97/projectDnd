package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.CharacterPg;
import progettino.dnd.projectDnd.model.entities.TiriSalvezza;
import progettino.dnd.projectDnd.model.entities.Type;

public class TiriSalvezzaDto {
    private long id;
    private Type type;
    private int point;
    private int modificatore;
    private long pgId; // ID del Personaggio (CharacterPg) associato

    public TiriSalvezzaDto() {
    }

    public TiriSalvezzaDto(long id, Type type, int point, int modificatore, long pgId) {
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


    public static TiriSalvezzaDto fromEntity(TiriSalvezza tiriSalvezza) {
        if (tiriSalvezza == null) {
            return null;
        }

        TiriSalvezzaDto tiriSalvezzaDto = new TiriSalvezzaDto();
        tiriSalvezzaDto.setId(tiriSalvezza.getId());
        tiriSalvezzaDto.setType(tiriSalvezza.getType());
        tiriSalvezzaDto.setPoint(tiriSalvezza.getPoint());
        tiriSalvezzaDto.setModificatore(tiriSalvezza.getModificatore());

        // Impostiamo l'ID del PG associato a questa entità TiriSalvezza
        if (tiriSalvezza.getPg() != null) {
            tiriSalvezzaDto.setPgId(tiriSalvezza.getPg().getId());
        }

        return tiriSalvezzaDto;
    }

    //TODO
    public TiriSalvezza toEntity() {

        TiriSalvezza tiriSalvezza = new TiriSalvezza();
        tiriSalvezza.setId(this.id);
        tiriSalvezza.setType(this.type);
        tiriSalvezza.setPoint(this.point);
        tiriSalvezza.setModificatore(this.modificatore);

        //

        return tiriSalvezza;
    }

}
