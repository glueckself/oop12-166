class ZertifikatStufe3 extends Zertifikat {
    public void allowed(Bauarbeiter bauarbeiter) {
	bauarbeiter.software.zertifikat = this;
    }

    public void allowed(ServiceTechniker serviceTechniker) {
	serviceTechniker.software.zertifikat = this;
    }

    public void allowed(Transportarbeiter transportarbeiter) {
	transportarbeiter.software.zertifikat = this;
    }

    public AktorKit allowedKit(AktorKit1kW aktorKit1kW) {
	return aktorKit1kW;
    }

    public AktorKit allowedKit(AktorKit4kW aktorKit4kW) {
	return aktorKit4kW;
    }

    public Zertifikat modify(Zertifikat zertifikat) {
	return zertifikat.modify(this);
    }

    public Zertifikat modify(ZertifikatStufe3 zertifikat) {
	return this;
    }
}
