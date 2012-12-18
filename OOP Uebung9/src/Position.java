
class Position {
    protected int anzahl;
    protected Form form;
    protected Teig teig;
    protected Fuellung fuellung;
    
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
    
    public String toString() {
        if(this.fuellung != null)
            return this.anzahl+" "+this.form.toString()+" "+this.teig.toString()+" "+this.fuellung.toString();
        else
            return this.anzahl+" "+this.form.toString()+" "+this.teig.toString();
    }
}
