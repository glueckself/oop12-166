class Kaempfer extends Beschuetzer {
    public Kaempfer(Skin skin, Software software) {
    name = "Kaempfer";
	skin.allowed(this);
	software.allowed(this);
    }
}
