class Objektbewacher extends Beschuetzer {
    public Objektbewacher(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Objektbewacher";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
}
