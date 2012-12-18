
class KeksbackManager {
    private Backmaschine maschine;
    public void set(Backmaschine maschine) {
        this.maschine = maschine;
    }
    public Keks neuerKeks(Teig teig) {
        return maschine.backe(teig);
    }
}
