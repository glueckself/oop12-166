class GepanzerteSkin extends Skin {
    public void allowed(Bediener bediener) {
	bediener.skin = null;
    }

    public void allowed(Schwerarbeiter schwerarbeiter) {
	schwerarbeiter.skin = null;
    }

    public void allowed(Beschuetzer beschuetzer) {
	beschuetzer.skin = this;
    }
}
