/**
 * ZertifikatStufe2
 */

class ZertifikatStufe2 extends Zertifikat {
    public void allowed(Hilfskraft hilfskraft) {
	hilfskraft.software.zertifikat = this;
    }

    public AktorKit allowedKit(AktorKit1kW aktorKit1kW) {
	return aktorKit1kW;
    }

    public Zertifikat modify(Zertifikat zertifikat) {
	return zertifikat.modify(this);
    }

    public Zertifikat modify(ZertifikatStufe2 zertifikat) {
	return this;
    }
}
