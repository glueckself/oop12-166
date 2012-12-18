
class WMannkeksBackmaschine extends Backmaschine {
    public WMannkeksBackmaschine() {
        
    }
    
    protected Keks backe(Teig teig) {
        return new Einzelkeks(new Weihnachtsmann(),teig);
    }
}
