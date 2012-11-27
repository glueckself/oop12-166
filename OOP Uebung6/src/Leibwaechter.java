class Leibwaechter extends Beschuetzer {
    public Leibwaechter(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Leibwaechter";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
}
