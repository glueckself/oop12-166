import java.util.ArrayList;

class Bestellung{
    private ArrayList<Position> positionen;
    
    public Bestellung() {
        this.positionen = new ArrayList<Position>();
    }
    
    /**
     * Eine Position zur Bestellung hinzufuegen.
     *
     * @param pos Neue Position != null
     */
    public void addPosition(Position pos) {
        positionen.add(pos);
    }
    
    /**
     * Alle Positionen der Bestellung zurueckgeben.
     *
     * @return ArrayList<Position> Alle Positionen der Bestellung
     */
    public ArrayList<Position> getPositionen() {
        return this.positionen;
    }
    
    /**
     * Gibt alle Positionen in der Standardausgabe aus.
     */
    public void drucke() {
        System.out.println("Bestellung");
        for(Position pos : positionen) {
            System.out.println(pos.toString());
        }
    }
}
