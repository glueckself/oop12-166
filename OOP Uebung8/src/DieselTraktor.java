@Member("Julian Grosshauser")
class DieselTraktor extends Traktor {
    protected int diesel;

    @Member("Julian Grosshauser")
    public DieselTraktor(int nummer, Role role) {
        super(nummer,role);
    }

    @Member("Julian Grosshauser")
    public void increaseDiesel(int value) {
	// negative values could lead to negative diesel consumption
	if(value > 0) {
	    this.diesel += value;
	}
    }

    @Member("Julian Grosshauser")
    public int getDiesel() {
	return this.diesel;
    }
}
