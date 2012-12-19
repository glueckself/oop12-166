class Doppelkeks implements Keks {
    private Einzelkeks boden,deckel;
    private Fuellung fuellung;
    
    /**
     * Doppelkeks besteht aus zwei Einzelkeksen und einer Fuellung.
     */
    public Doppelkeks(Einzelkeks boden, Einzelkeks deckel, Fuellung fuellung) {
        this.boden = boden;
        this.deckel = deckel;
        this.fuellung = fuellung;
    }
    
    /**
     * Gibt die Bestandteile des Doppelkeks als String an.
     *
     * @return String Bestandteile des Doppelkeks
     */
    public String toString() {
        return "Doppelkeks "+this.boden.getForm().toString()+" "+this.boden.getTeig().toString()+" "+this.fuellung.toString();
    }
}
