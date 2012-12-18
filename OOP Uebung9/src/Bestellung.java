import java.util.ArrayList;

class Bestellung{
    private ArrayList<Position> positionen;
    
    public Bestellung() {
        this.positionen = new ArrayList<Position>();
    }
    
    public void addPosition(Position pos) {
        positionen.add(pos);
    }
    
    public ArrayList<Position> getPositionen() {
        return this.positionen;
    }
    
    public void drucke() {
        System.out.println("Bestellung");
        for(Position pos : positionen) {
            System.out.println(pos.anzahl+" "+pos.form+" "+pos.teig+" "+pos.fuellung);
        }
    }
}
