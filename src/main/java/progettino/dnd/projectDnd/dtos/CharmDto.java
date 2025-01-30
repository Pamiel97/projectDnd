package progettino.dnd.projectDnd.dtos;

import progettino.dnd.projectDnd.model.entities.Type;

import java.util.List;

public class CharmDto {
    private long id;
    private String name;
    private String description;
    private String actionTime;
    private int gittate;  // distanza o gittata dell'incantesimo
    private int duration;  // durata dell'incantesimo
    private int dice;  // i dadi utilizzati per calcolare i danni, ad esempio
    private int hitDice;  // dadi per il colpo
    private int healthDice;  // dadi per la salute
    private String component;  // componenti richiesti per l'incantesimo (es. verbale, somatico, materiale)
    private boolean preparate;  // se l'incantesimo è preparato
    private int minLevel;  // livello minimo per l'incantesimo
    private Type type;  

    private List<SlotDto> slots;  // Lista di SlotDto che contengono questo incantesimo

}
