
class Position {
    private int anzahl;
    private Form form;
    private Teig teig;
    private Fuellung fuellung;
    
    public Position(int anzahl, Form form, Teig teig) {
        this.anzahl = anzahl;
        this.form = form;
        this.teig = teig;
        this.fuellung = null;
    }
    
    public Position(int anzahl, Form form, Teig teig, Fuellung fuellung) {
        this.anzahl = anzahl;
        this.form = form;
        this.teig = teig;
        this.fuellung = fuellung;
    }
    
    public int getAnzahl() {
        return this.anzahl;
    }
    
    public Form getForm() {
        return this.form;
    }
    
    public Teig getTeig() {
        return this.teig;
    }
    
    public Fuellung getFuellung() {
        return this.fuellung;
    }
    
    public String toString() {
        if(this.fuellung != null)
            return this.anzahl+" "+this.form.toString()+" "+this.teig.toString()+" "+this.fuellung.toString();
        else
            return this.anzahl+" "+this.form.toString()+" "+this.teig.toString();
    }
}
