class Hilfskraft extends Bediener {
    public Hilfskraft(Skin skin, Software software) {
	skin.allowed(this);
	software.allowed(this);
    }
}
