/**
 * Hilfskraft Android
 */

class Hilfskraft extends Bediener {
    /**
     * Assemble Android
     *
     * @param skin Skin to use
     * @param software Software to use
     * @param zertifikat Zertifikat to use
     * @param kit AktorKit to use
     */
    public Hilfskraft(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	name = "Hilfskraft";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
    
    public Android modify(Android android) {
        return android.modify(this);
    }
    public Android modify(Hilfskraft hilfskraft) {
        return hilfskraft;
    }
    public Android modify(Gesellschafter gesellschafter) {
        return gesellschafter;
    }
}
