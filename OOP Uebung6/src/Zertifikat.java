abstract class Zertifikat {
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

        public AktorKit allowedKit(AktorKit1kW aktorKit1kW) {
        return null;
        }

        public AktorKit allowedKit(AktorKit4kW aktorKit4kW) {
        return null;
        }

        public AktorKit allowedKit(AktorKit12kW aktorKit12kW) {
        return null;
        }

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
