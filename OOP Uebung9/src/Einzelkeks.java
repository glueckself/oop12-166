
class Einzelkeks implements Keks {
    private Form form;
    private Teig teig;
    
    public Einzelkeks(Form form, Teig teig) {
        this.form = form;
        this.teig = teig;
    }
    
    public Form getForm() {
        return this.form;
    }
    
    public Teig getTeig() {
        return this.teig;
    }
    
    public Einzelkeks duplicate(Einzelkeks orig) {
        try {
            Einzelkeks copy = (Einzelkeks)orig.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    public String toString() {
        return "Einzelkeks "+this.form.toString()+" "+this.teig.toString();
    }
}
