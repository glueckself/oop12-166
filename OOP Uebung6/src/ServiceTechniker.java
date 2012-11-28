/**
 * ServiceTechniker Android
 */

class ServiceTechniker extends Schwerarbeiter {
    /**
     * Assemble Android
     *
     * @param skin Skin to use
     * @param software Software to use
     * @param zertifikat Zertifikat to use
     * @param kit AktorKit to use
     */
    public ServiceTechniker(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Servicetechniker";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
    
    public Android modify(Android android) {
        return android.modify(this);
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
