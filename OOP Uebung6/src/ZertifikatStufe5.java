class ZertifikatStufe5 extends Zertifikat {
    public void allowed(Kaempfer kaempfer) {
	kaempfer.software.zertifikat = this;
    }

    public AktorKit allowedKit(AktorKit1kW aktorKit1kW) {
	return aktorKit1kW;
    }

    public AktorKit allowedKit(AktorKit4kW aktorKit4kW) {
	return aktorKit4kW;
    }

    public AktorKit allowedKit(AktorKit12kW aktorKit12kW) {
	return aktorKit12kW;
    }

    public Zertifikat modify(Zertifikat zertifikat) {
	return zertifikat.modify(this);
    }
    
    public Zertifikat modify(ZertifikatStufe5 zertifikat) {
	return this;
    }
}
