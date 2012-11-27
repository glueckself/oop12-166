class ServiceTechniker extends Schwerarbeiter {
    public ServiceTechniker(Skin skin, Software software) {
    name = "Servicetechniker";
	skin.allowed(this);
	software.allowed(this);
    }
}
