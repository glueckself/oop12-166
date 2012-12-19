class DoppelkeksBackmaschine {
    /**
     * Backe Doppelkeks.
     *
     * @param keks Einzelkeks der fuer den oberen und unteren Teil des
     * Doppelkeks verwendet werden soll != null
     * @param fuellung Fuellung die verwendet werden soll != null
     * @return Keks Fertiger Keks
     */
    public Keks backe(Einzelkeks keks, Fuellung fuellung) {
        return new Doppelkeks(keks,keks.duplicate(),fuellung);
    }
}
