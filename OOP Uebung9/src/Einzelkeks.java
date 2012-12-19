
class Einzelkeks implements Keks {
    private Form form;
    private Teig teig;
    
    /**
     * Einzelkeks besteht aus einer Form und einem Teig.
     */
    public Einzelkeks(Form form, Teig teig) {
        this.form = form;
        this.teig = teig;
    }
    
    /**
     * Gibt Form zurueck.
     *
     * @return Form Form des Einzelkeks
     */
    public Form getForm() {
        return this.form;
    }
    
    /**
     * Gibt Teig zurueck.
     *
     * @return Teig Teig des Einzelkeks
     */
    public Teig getTeig() {
        return this.teig;
    }
    
    /**
     * Erstellt Kopie des Einzelkeks.
     *
     * @return Einzelkeks Kopie des Einzelkeks
     */
    public Einzelkeks duplicate() {
        try {
            Einzelkeks copy = (Einzelkeks)this.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    /**
     * Gibt die Bestandteile des Einzelkeks als String an.
     *
     * @return String Bestandteile des Einzelkeks
     */
    public String toString() {
        return "Einzelkeks "+this.form.toString()+" "+this.teig.toString();
    }
}
