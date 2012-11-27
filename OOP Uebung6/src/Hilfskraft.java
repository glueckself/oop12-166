class Hilfskraft extends Bediener {
    public Hilfskraft(Skin skin, Software software, Zertifikat zertifikat, AktorKit kit) {
	this.name = "Hilfskraft";
	skin.allowed(this);
	software.allowed(this);
	zertifikat.allowed(this);
	this.kit = kit.allowed(this);
    }
    
    public Android modify(Hilfskraft hilfskraft) {
        return hilfskraft;
    }
    public Android modify(Gesellschafter gesellschafter) {
        return gesellschafter;
    }
}
