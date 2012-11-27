class HochfesteSkin extends Skin {
	
	public HochfesteSkin() {
		name = "HochfesteSkin";
	}
	
    public void allowed(Bediener bediener) {
	bediener.skin = null;
    }

    public void allowed(Schwerarbeiter schwerarbeiter) {
	schwerarbeiter.skin = this;
    }

    public void allowed(Beschuetzer beschuetzer) {
	beschuetzer.skin = this;
    }
}
