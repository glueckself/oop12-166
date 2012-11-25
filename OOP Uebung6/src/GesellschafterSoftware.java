class GesellschafterSoftware extends Software {
    public GesellschafterSoftware(Zertifikat zertifikat) {
	zertifikat.allowed(this);
    }

    public void allowed(Hilfskraft hilfskraft) {
	hilfskraft.software = null;	
    }

    public void allowed(Gesellschafter gesellschafter) {
	if(this.zertifikat != null) {
	    gesellschafter.software = this;
	} else {
	    gesellschafter.software = null;
	}
    }

    public void allowed(Bauarbeiter bauarbeiter) {
	bauarbeiter.software = null;
    }

    public void allowed(ServiceTechniker serviceTechniker) {
	serviceTechniker.software = null;
    }

    public void allowed(Transportarbeiter transportarbeiter) {
	transportarbeiter.software = null;
    }

    public void allowed(Objektbewacher objektbewacher) {
	objektbewacher.software = null;
    }

    public void allowed(Leibwaechter leibwaechter) {
	leibwaechter.software = null;
    }

    public void allowed(Kaempfer kaempfer) {
	kaempfer.software = null;
    }
}
