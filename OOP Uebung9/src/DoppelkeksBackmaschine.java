
class DoppelkeksBackmaschine {
    
    public DoppelkeksBackmaschine() {
        
    }
    
    public Keks backe(Einzelkeks keks, Fuellung fuellung) {
        return new Doppelkeks(keks,keks.duplicate(),fuellung);
    }
}
