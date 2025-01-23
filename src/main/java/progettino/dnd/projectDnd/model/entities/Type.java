package progettino.dnd.projectDnd.model.entities;

public enum Type {
    FORZA("Misura la potenza fisica."),
    DESTREZZA("Misura l'agilità, il riflesso e l'equilibrio."),
    COSTITUZIONE("Misura la resistenza fisica e la capacità di recupero."),
    INTELLIGENZA("Misura la capacità analitica e l'istruzione."),
    SAGGEZZA("Misura la percezione, l'intuizione e la consapevolezza."),
    CARISMA("Misura la forza di personalità, il fascino e la leadership.");

    private final String descrizione;

    Type(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public static void main(String[] args) {
        for (Type caratteristica : Type.values()) {
            System.out.println(caratteristica.name() + ": " + caratteristica.getDescrizione());
        }
    }
}
