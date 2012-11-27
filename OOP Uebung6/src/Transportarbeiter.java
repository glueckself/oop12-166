class Transportarbeiter extends Schwerarbeiter {
    public Transportarbeiter(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Transportarbeiter";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
}
