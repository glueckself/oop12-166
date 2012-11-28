/**
 * Gesellschafter Android
 */

class Gesellschafter extends Bediener {
    /**
     * Assemble Android
     *
     * @param skin Skin to use
     * @param software Software to use
     * @param zertifikat Zertifikat to use
     * @param kit AktorKit to use
     */
    public Gesellschafter(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
    name = "Gesellschafter";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
    
    public Android modify(Android android) {
        return android.modify(this);
    }
    public Android modify(Gesellschafter gesellschafter) {
        return gesellschafter;
    }
    public Android modify(Hilfskraft hilfskraft) {
        return hilfskraft;
    }
}
