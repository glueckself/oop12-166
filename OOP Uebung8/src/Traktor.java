@Member("Julian Großhauser")
abstract class Traktor {
    protected final int nummer;
    protected int betriebsstunden;
    protected Role role;
    
    @Member("Julian Großhauser")
    public Traktor(int nummer, Role role) {
        this.nummer = nummer;
        this.role = role;
    }
    
    @Member("Alex Huber")
    public int getNummer() {
        return this.nummer;
    }
    
    @Member("Julian Großhauser")
    public void increaseBetriebsstunden(int value) {
	// negative values could lead to negative betriebsstunden
	if(value > 0) {
	    this.betriebsstunden += value;
	}
    }
    
    @Member("Julian Großhauser")
    public int getBetriebsstunden() {
	return this.betriebsstunden;
    }
    
    @Member("Alex Huber")
    public Role getRole() {
        return this.role;
    }
    
    @Member("Alex Huber")
    public void changeRole(Role role) {
        this.role = role;
    }
}
