abstract class Software {
    protected Zertifikat zertifikat;
    protected String name;

    public abstract void allowed(Hilfskraft hilfskraft);
    public abstract void allowed(Gesellschafter gesellschafter);
    public abstract void allowed(Bauarbeiter bauarbeiter);
    public abstract void allowed(ServiceTechniker serviceTechniker);
    public abstract void allowed(Transportarbeiter transportarbeiter);
    public abstract void allowed(Objektbewacher objektbewacher);
    public abstract void allowed(Leibwaechter leibwaechter);
    public abstract void allowed(Kaempfer kaempfer);
    
    public String toString() {
    	return name;
    }
}
