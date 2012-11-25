class Leibwaechter extends Beschuetzer {
    public Leibwaechter(Skin skin, Software software) {
	skin.allowed(this);
	software.allowed(this);
    }
}
