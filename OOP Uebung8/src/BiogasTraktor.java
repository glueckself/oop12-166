class BiogasTraktor extends Traktor {
    protected double gas;

    public BiogasTraktor(int nummer, Role role) {
	super(nummer, role);
    }

    public void increaseBiogas(double value) {
	// negative values could lead to negative diesel consumption
	if(value > 0) {
	    this.gas += value;
	}
    }

    public double getBiogas() {
	return this.gas;
    }
}
