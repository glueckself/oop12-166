abstract class Traktor {
    protected final int nummer;
    protected int betriebsstunden;

    public Traktor(int nummer) {
	this.nummer = nummer;
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
}
