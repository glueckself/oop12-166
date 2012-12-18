
class DoppelkeksBackmaschine {
    public Keks backe(Einzelkeks keks, Fuellung fuellung) {
        Einzelkeks deckel = keks.duplicate(keks);
        return new Doppelkeks(keks,deckel,fuellung);
    }
}
