class Leibwaechter extends Beschuetzer {
    public Leibwaechter(Skin skin, Software software) {
    name = "Leibwaechter";
	skin.allowed(this);
	software.allowed(this);
    }
}
