class ZertifikatStufe3 extends Zertifikat {
    public void allowed(HilfskraftSoftware hilfskraftSoftware) {
	hilfskraftSoftware.zertifikat = null;
    }

    public void allowed(GesellschafterSoftware gesellschafterSoftware) {
	gesellschafterSoftware.zertifikat = null;
    }
    
    public void allowed(BauarbeiterSoftware bauarbeiterSoftware) {
	bauarbeiterSoftware.zertifikat = this;
    }

    public void allowed(ServiceTechnikerSoftware serviceTechnikerSoftware) {
	serviceTechnikerSoftware.zertifikat = this;
    }

    public void allowed(TransportarbeiterSoftware transportarbeiterSoftware) {
	transportarbeiterSoftware.zertifikat = this;
    }

    public void allowed(ObjektbewacherSoftware objektbewacherSoftware) {
	objektbewacherSoftware.zertifikat = null;
    }

    public void allowed(LeibwaechterSoftware leibwaechterSoftware) {
	leibwaechterSoftware.zertifikat = null;
    }

    public void allowed(KaempferSoftware kaempferSoftware) {
	kaempferSoftware.zertifikat = null;
    }
}
