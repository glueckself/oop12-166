abstract class Traktor {
    protected final int nummer;
    protected int betriebsstunden;
    protected Role role;

    public Traktor(int nummer, Role role) {
        this.nummer = nummer;
        this.role = role;
    }
    
    public int getNummer() {
        return this.nummer;
    }

    public void increaseBetriebsstunden(int value) {
	// negative values could lead to negative betriebsstunden
	if(value > 0) {
	    this.betriebsstunden += value;
	}
    }

    public int getBetriebsstunden() {
	return this.betriebsstunden;
    }
    
    Role getRole() {
        return this.role;
    }
    
    void changeRole(Role role) {
        this.role = role;
    }
}
