class MondkeksBackmaschine extends Backmaschine {
    /**
     * Backt Keks.
     *
     * @param teig Der fuer den Keks zu verwendende Teig != null
     * @return Keks Der fertige Keks
     */
    protected Keks backe(Teig teig) {
        return new Einzelkeks(new Mond(),teig);
    }
}
