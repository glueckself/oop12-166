class Transportarbeiter extends Schwerarbeiter {
    public Transportarbeiter(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Transportarbeiter";
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
