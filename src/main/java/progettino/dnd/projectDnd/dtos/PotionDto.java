package progettino.dnd.projectDnd.dtos;

public class PotionDto {
    private long id;
    private String name;
    private String description;
    private int dice;  // Dadi utilizzati per il calcolo dell'effetto o danno
    private int diceHealth;  // Dadi per la salute, se applicabile
    private int diceAttack;  // Dadi per l'attacco, se applicabile
    private String note;  // Eventuali note aggiuntive
    private int cost;  // Costo dell'oggetto

    private BagDto bag;  // DTO per la borsa a cui appartiene l'oggetto
}
