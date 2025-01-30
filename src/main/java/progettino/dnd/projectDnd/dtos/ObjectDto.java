package progettino.dnd.projectDnd.dtos;

public class ObjectDto {
    private long id;
    private String name;       // Nome dell'oggetto (ad esempio, "Dado della Fortuna")
    private String description; // Descrizione dell'oggetto
    private String note;        // Eventuali note aggiuntive
    private String effect;      // Effetto dell'oggetto (ad esempio, "Causa 1d6 danni")
    private String rarity;      // Rarità dell'oggetto (ad esempio, "Comune", "Rara", ecc.)
    private String cost;        // Costo dell'oggetto (potrebbe essere in monete d'oro, ecc.)
    private int dice;           // Numero di dadi utilizzati per determinare l'effetto
    private int attack;         // Valore di attacco associato all'oggetto
    private int health;         // Valore di salute o cura associato all'oggetto

    private BagDto bag;
}
