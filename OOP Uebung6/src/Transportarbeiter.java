class Transportarbeiter extends Schwerarbeiter {
    public Transportarbeiter(Skin skin, Software software) {
    name = "Transportarbeiter";
	skin.allowed(this);
	software.allowed(this);
    }
}
