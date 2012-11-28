/**
 * Objektbewacher Android
 */

class Objektbewacher extends Beschuetzer {
    /**
     * Assemble Android
     *
     * @param skin Skin to use
     * @param software Software to use
     * @param zertifikat Zertifikat to use
     * @param kit AktorKit to use
     */
    public Objektbewacher(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Objektbewacher";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
    
    public Android modify(Android android) {
        return android.modify(this);
    }
    public Android modify(Leibwaechter leibwaechter) {
        return leibwaechter;
    }
    public Android modify(Objektbewacher objektbewacher) {
        return objektbewacher;
    }
}
