class Transportarbeiter extends Schwerarbeiter {
    public Transportarbeiter(Skin skin, Software software) {
	skin.allowed(this);
	software.allowed(this);
    }
}
