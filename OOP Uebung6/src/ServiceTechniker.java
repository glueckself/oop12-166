class ServiceTechniker extends Schwerarbeiter {
    public ServiceTechniker(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Servicetechniker";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
    
    public Android modify(Bauarbeiter bauarbeiter) {
        return bauarbeiter;
    }
    public Android modify(ServiceTechniker servicetechniker) {
        return servicetechniker;
    }
    public Android modify(Transportarbeiter transportarbeiter) {
        return transportarbeiter;
    }
}
