class Objektbewacher extends Beschuetzer {
    public Objektbewacher(Skin skin, Software software) {
	skin.allowed(this);
	software.allowed(this);
    }
}
