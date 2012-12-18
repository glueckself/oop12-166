
class Einzelkeks implements Keks {
    Form form;
    Teig teig;
    
    public Einzelkeks(Form form, Teig teig) {
        this.form = form;
        this.teig = teig;
    }
    
    public Einzelkeks duplicate(Einzelkeks orig) {
        try {
            Einzelkeks copy = (Einzelkeks)orig.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
