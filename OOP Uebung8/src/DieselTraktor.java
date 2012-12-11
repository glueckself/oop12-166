@Member("Julian Großhauser")
class DieselTraktor extends Traktor {
    protected int diesel;

    @Member("Julian Großhauser")
    public DieselTraktor(int nummer, Role role) {
        super(nummer,role);
    }

    @Member("Julian Großhauser")
    public void increaseDiesel(int value) {
	// negative values could lead to negative diesel consumption
	if(value > 0) {
	    this.diesel += value;
	}
    }

    @Member("Julian Großhauser")
    public int getDiesel() {
	return this.diesel;
    }
}
