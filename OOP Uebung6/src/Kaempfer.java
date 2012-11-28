/**
 * Kaempfer Android
 */

class Kaempfer extends Beschuetzer {
    /*
     * Assemble Android
     *
     * @param skin Skin to use
     * @param software Software to use
     * @param zertifikat Zertifikat to use
     * @param kit AktorKit to use
     */
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
        return kaempfer;
    }
}
