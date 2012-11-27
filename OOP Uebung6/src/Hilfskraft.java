class Hilfskraft extends Bediener {
    public Hilfskraft(Skin skin, Software software) {
    name = "Hilfskraft";
	skin.allowed(this);
	software.allowed(this);
    }
}
