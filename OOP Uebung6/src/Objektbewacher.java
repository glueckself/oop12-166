class Objektbewacher extends Beschuetzer {
    public Objektbewacher(Skin skin, Software software) {
    name = "Objektbewacher";
	skin.allowed(this);
	software.allowed(this);
    }
}
