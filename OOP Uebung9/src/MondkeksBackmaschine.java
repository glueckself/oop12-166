
class MondkeksBackmaschine extends Backmaschine {
    public MondkeksBackmaschine() {
        
    }
    
    protected Keks backe(Teig teig) {
        return new Einzelkeks(new Mond(),teig);
    }
}
