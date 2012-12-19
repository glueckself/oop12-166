class Position {
    private int anzahl;
    private Form form;
    private Teig teig;
    private Fuellung fuellung;
    
    /**
     * Position fuer Einzelkeks.
     */
    public Position(int anzahl, Form form, Teig teig) {
        this.anzahl = anzahl;
        this.form = form;
        this.teig = teig;
        this.fuellung = null;
    }
    
    /**
     * Position fuer Doppelkeks.
     */
    public Position(int anzahl, Form form, Teig teig, Fuellung fuellung) {
        this.anzahl = anzahl;
        this.form = form;
        this.teig = teig;
        this.fuellung = fuellung;
    }
    
    /**
     * Gibt Anzahl zurueck.
     *
     * @return int Anzahl
     */
    public int getAnzahl() {
        return this.anzahl;
    }
    
    /**
     * Gibt Form zurueck.
     *
     * @return Form Form
     */
    public Form getForm() {
        return this.form;
    }
    
    /**
     * Gibt Teig zurueck.
     *
     * @return Teig Teig
     */
    public Teig getTeig() {
        return this.teig;
    }
    
    /**
     * Gibt Fuellung zurueck.
     *
     * @return Fuellung Fuellung
     */
    public Fuellung getFuellung() {
        return this.fuellung;
    }
    
    /**
     * Gibt den Inhalt der Position als String zurueck.
     *
     * @return String Inhalt der Position
     */
    public String toString() {
        if(this.fuellung != null)
            return this.anzahl+" "+this.form.toString()+" "+this.teig.toString()+" "+this.fuellung.toString();
        else
            return this.anzahl+" "+this.form.toString()+" "+this.teig.toString();
    }
}
