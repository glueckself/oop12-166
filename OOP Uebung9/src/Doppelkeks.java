
class Doppelkeks implements Keks {
    Einzelkeks boden,deckel;
    Fuellung fuellung;
    
    public Doppelkeks(Einzelkeks boden, Einzelkeks deckel, Fuellung fuellung) {
        this.boden = boden;
        this.deckel = deckel;
        this.fuellung = fuellung;
    }
}
