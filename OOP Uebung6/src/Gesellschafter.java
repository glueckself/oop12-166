class Gesellschafter extends Bediener {
    public Gesellschafter(Skin skin, Software software) {
    name = "Gesellschafter";
	skin.allowed(this);
	software.allowed(this);
    }
}
