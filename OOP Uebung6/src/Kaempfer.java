class Kaempfer extends Beschuetzer {
    public Kaempfer(Skin skin, Software software) {
	skin.allowed(this);
	software.allowed(this);
    }
}
