
class Position {
    protected int anzahl;
    protected Form form;
    protected Teig teig;
    protected Fuellung fuellung;
    
    public Position(int anzahl, Form form, Teig teig, Fuellung fuellung) {
        this.anzahl = anzahl;
        this.form = form;
        this.teig = teig;
        this.fuellung = fuellung;
    }
}
