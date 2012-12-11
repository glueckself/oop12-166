class DieselTraktor extends Traktor {
    protected int diesel;

    public DieselTraktor(int nummer, Role role) {
        super(nummer,role);
    }

    public void increaseDiesel(int value) {
	// negative values could lead to negative diesel consumption
	if(value > 0) {
	    this.diesel += value;
	}
    }

    public int getDiesel() {
	return this.diesel;
    }
}
