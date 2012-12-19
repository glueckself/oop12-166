class WMannkeksBackmaschine extends Backmaschine {
    /**
     * Backt neuen Keks.
     * 
     * @param teig Der zu verwendende Teig != null
     * @return Keks Der fertige Keks
     */
    protected Keks backe(Teig teig) {
        return new Einzelkeks(new Weihnachtsmann(),teig);
    }
}
