class ZertifikatStufe5 extends Zertifikat {
    public void allowed(HilfskraftSoftware hilfskraftSoftware) {
	hilfskraftSoftware.zertifikat = null;
    }

    public void allowed(GesellschafterSoftware gesellschafterSoftware) {
	gesellschafterSoftware.zertifikat = null;
    }
    
    public void allowed(BauarbeiterSoftware bauarbeiterSoftware) {
	bauarbeiterSoftware.zertifikat = null;
    }

    public void allowed(ServiceTechnikerSoftware serviceTechnikerSoftware) {
	serviceTechnikerSoftware.zertifikat = null;
    }

    public void allowed(TransportarbeiterSoftware transportarbeiterSoftware) {
	transportarbeiterSoftware.zertifikat = null;
    }

    public void allowed(ObjektbewacherSoftware objektbewacherSoftware) {
	objektbewacherSoftware.zertifikat = null;
    }

    public void allowed(LeibwaechterSoftware leibwaechterSoftware) {
	leibwaechterSoftware.zertifikat = null;
    }

    public void allowed(KaempferSoftware kaempferSoftware) {
	kaempferSoftware.zertifikat = this;
    }
}
