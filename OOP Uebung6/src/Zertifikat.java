/**
 * Zertifikat
 */

abstract class Zertifikat {
    /**
     * Check if android is allowed to use this zertifikat
     * @param android Android to check
     */
    public void allowed(Hilfskraft hilfskraft) {
        hilfskraft.software.zertifikat = null;
    }

    public void allowed(Gesellschafter gesellschafter) {
        gesellschafter.software.zertifikat = null;
    }
        
    public void allowed(Bauarbeiter bauarbeiter) {
        bauarbeiter.software.zertifikat = null;
    }

    public void allowed(ServiceTechniker serviceTechniker) {
        serviceTechniker.software.zertifikat = null;
    }

    public void allowed(Transportarbeiter transportarbeiter) {
        transportarbeiter.software.zertifikat = null;
    }

    public void allowed(Objektbewacher objektbewacher) {
        objektbewacher.software.zertifikat = null;
    }

    public void allowed(Leibwaechter leibwaechter) {
        leibwaechter.software.zertifikat = null;
    }

    public void allowed(Kaempfer kaempfer) {
        kaempfer.software.zertifikat = null;
    }

    /**
     * Check if aktorKit is allowed when using this zertifikat
     * @param aktorKit AktorKit to check
     */
    public AktorKit allowedKit(AktorKit1kW aktorKit1kW) {
        return null;
    }

    public AktorKit allowedKit(AktorKit4kW aktorKit4kW) {
        return null;
    }

    public AktorKit allowedKit(AktorKit12kW aktorKit12kW) {
        return null;
    }

    /**
     * Check if zertifikat isn't changed when modifying android
     * @param zertifikat Zertifikat to check
     */
    public abstract Zertifikat modify(Zertifikat zertifikat);

    public Zertifikat modify(ZertifikatStufe1 zertifikat) {
        return null;
    }

    public Zertifikat modify(ZertifikatStufe2 zertifikat) {
        return null;
    }

    public Zertifikat modify(ZertifikatStufe3 zertifikat) {
        return null;
    }

    public Zertifikat modify(ZertifikatStufe4 zertifikat) {
        return null;
    }

    public Zertifikat modify(ZertifikatStufe5 zertifikat) {
        return null;
    }
}
