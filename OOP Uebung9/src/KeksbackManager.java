class KeksbackManager {
    private Backmaschine maschine;

    /**
     * Setzen der zu verwendenden Backmaschine.
     *
     * @param maschine Die zu verwendende Backmaschine != null
     */
    public void set(Backmaschine maschine) {
        this.maschine = maschine;
    }

    /**
     * Backt einen neuen Keks.
     *
     * @param teig Teig der fuer den neuen Keks verwendet werden soll != null
     * @return Keks Neuer Keks
     */
    public Keks neuerKeks(Teig teig) {
        return maschine.backe(teig);
    }
}
