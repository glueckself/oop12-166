class ServiceTechniker extends Schwerarbeiter {
    public ServiceTechniker(Skin skin, Software software) {
	skin.allowed(this);
	software.allowed(this);
    }
}
