class Bauarbeiter extends Schwerarbeiter {
    public Bauarbeiter(Skin skin, Software software) {
    name = "Bauarbeiter";
	skin.allowed(this);
	software.allowed(this);
    }
}
