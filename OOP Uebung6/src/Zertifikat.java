abstract class Zertifikat {
    public abstract void allowed(Hilfskraft hilfskraft);
    public abstract void allowed(Gesellschafter gesellschafter);
    public abstract void allowed(Bauarbeiter bauarbeiter);
    public abstract void allowed(ServiceTechniker serviceTechniker);
    public abstract void allowed(Transportarbeiter transportarbeiteroftware);
    public abstract void allowed(Objektbewacher objektbewacher);
    public abstract void allowed(Leibwaechter leibwaechter);
    public abstract void allowed(Kaempfer kaempfer);
    public abstract AktorKit allowedKit(AktorKit1kW aktorKit1kW);
    public abstract AktorKit allowedKit(AktorKit4kW aktorKit4kW);
    public abstract AktorKit allowedKit(AktorKit12kW aktorKit12kW);
    public abstract Zertifikat modify(Zertifikat zertifikat);
    public abstract Zertifikat modify(ZertifikatStufe1 zertifikat);
    public abstract Zertifikat modify(ZertifikatStufe2 zertifikat);
    public abstract Zertifikat modify(ZertifikatStufe3 zertifikat);
    public abstract Zertifikat modify(ZertifikatStufe4 zertifikat);
    public abstract Zertifikat modify(ZertifikatStufe5 zertifikat);
}
