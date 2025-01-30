package progettino.dnd.projectDnd.dtos;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CharacterPgDto {

    private long id;
    private String name;
    private String surname;
    private String classe;
    private String race;
    private int level;
    private String background;
    private String allignment;
    private int exp;
    private String physicalTrait;
    private int ispiration;
    private int bonusCompetence;
    private int perception;
    private int ca;
    private int iniziative;
    private int speed;
    private int totalHp;
    private int actualHp;
    private int temporanyHp;
    private int dice;
    private int diceHealth;
    private String caratterial;
    private String ideals;
    private String note;
    private int money;
    private String img;

    private long userId;  // prendere id

    private List<SlotDto> slots;  // Lista di SlotDto
    private BagDto bag;  // DTO per la borsa
    private DiaryDto diary;  // DTO per il diario

    private List<AbilityPgDto> abilityPgs;  // Lista di AbilityPgDto
    private List<StaticDto> staticList;  // Lista di StaticDto
    private List<TiriSalvezzaDto> tiriSalvezza;  // Lista di TiriSalvezzaDto

    private CampaignDto campaign;  // DTO per la campagna

    private List<TalentDto> talents;  // Lista di TalentDto
    private List<TraitDto> traits;  // Lista di TraitDto

}
