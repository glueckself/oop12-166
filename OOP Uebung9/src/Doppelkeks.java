
class Doppelkeks implements Keks {
    private Einzelkeks boden,deckel;
    private Fuellung fuellung;
    
    public Doppelkeks(Einzelkeks boden, Einzelkeks deckel, Fuellung fuellung) {
        this.boden = boden;
        this.deckel = deckel;
        this.fuellung = fuellung;
    }
    
    public String toString() {
        return "Doppelkeks "+this.boden.getForm().toString()+" "+this.boden.getTeig().toString()+" "+this.fuellung.toString();
    }
}
