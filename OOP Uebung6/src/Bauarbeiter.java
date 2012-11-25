class Bauarbeiter extends Schwerarbeiter {
    public Bauarbeiter(Skin skin, Software software) {
	skin.allowed(this);
	software.allowed(this);
    }
}
