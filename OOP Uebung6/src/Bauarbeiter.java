class Bauarbeiter extends Schwerarbeiter {
    public Bauarbeiter(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Bauarbeiter";
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
