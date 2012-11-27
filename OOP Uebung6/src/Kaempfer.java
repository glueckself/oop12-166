class Kaempfer extends Beschuetzer {
    public Kaempfer(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Kaempfer";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
    
    public Android modify(Android android) {
        return android.modify(this);
    }
    public Android modify(Kaempfer kaempfer) {
        return null;
    }
}
