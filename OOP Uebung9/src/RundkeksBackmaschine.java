
class RundkeksBackmaschine extends Backmaschine {
    public RundkeksBackmaschine() {
        
    }
    
    protected Keks backe(Teig teig) {
        return new Einzelkeks(new Rund(),teig);
    }
}
