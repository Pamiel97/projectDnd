package progettino.dnd.projectDnd.dtos;

public class WeaponDto {
    private long id;
    private String name;
    private String description;
    private String magicEffect;  // Effetto magico dell'arma, se presente
    private int dice;            // Dadi per il danno, ad esempio 1d6
    private int diceAttack;      // Dadi per l'attacco
    private String note;         // Eventuali note aggiuntive sull'arma
    private int cost;            // Costo dell'arma

    private BagDto bag;
}
