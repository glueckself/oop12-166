@Member("Julian Grosshauser")
class BiogasTraktor extends Traktor {
    protected double gas;
    
    @Member("Julian Grosshauser")
    public BiogasTraktor(int nummer, Role role) {
	super(nummer, role);
    }
    
    @Member("Julian Grosshauser")
    public void increaseBiogas(double value) {
	// negative values could lead to negative diesel consumption
	if(value > 0) {
	    this.gas += value;
	}
    }
    
    @Member("Julian Grosshauser")
    public double getBiogas() {
	return this.gas;
    }
}
