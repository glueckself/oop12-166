abstract class Backmaschine {
    /**
     * Backt einen Keks.
     *
     * @param teig Teig der fuer den Keks verwendet werden soll != null
     * @return Keks Der fertige Keks
     */
    protected abstract Keks backe(Teig teig);
}
