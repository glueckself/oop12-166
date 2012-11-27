class Gesellschafter extends Bediener {
    public Gesellschafter(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
    name = "Gesellschafter";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
    
    public Android modify(Gesellschafter gesellschafter) {
        return gesellschafter;
    }
    public Android modify(Hilfskraft hilfskraft) {
        return hilfskraft;
    }
}
