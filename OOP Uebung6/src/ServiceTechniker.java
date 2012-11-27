class ServiceTechniker extends Schwerarbeiter {
    public ServiceTechniker(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Servicetechniker";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
}
