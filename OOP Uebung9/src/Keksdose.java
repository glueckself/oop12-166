import java.util.ArrayList;

class Keksdose {
    private ArrayList<Keks> kekse;
    
    public Keksdose() {
        this.kekse = new ArrayList<Keks>();
    }
    
    /**
     * Neuen Keks zur Keksdose hinzufuegen.
     *
     * @param keks Der hinzuzufuegende Keks
     */
    public void addKeks(Keks keks) {
        this.kekse.add(keks);
    }
    
    /**
     * Gibt den Inhalt der Keksdose in der Standardausgabe aus.
     */
    public void inhalt() {
        System.out.println("Inhalt");
        for(Keks keks : kekse) {
            System.out.println(keks.toString());
        }
    }
}
