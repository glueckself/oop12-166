class Gesellschafter extends Bediener {
    public Gesellschafter(Skin skin, Software software) {
	skin.allowed(this);
	software.allowed(this);
    }
}
