class AktorKit1kW extends AktorKit {
    private Aktor aktor1kW;

    public AktorKit1kW() {
	name = "Aktor Kit 1kW";
	this.aktor1kW = new Aktor1kW();
    }

    public AktorKit allowed(Android android) {
	if(android.software.zertifikat != null) {
	    return android.software.zertifikat.allowedKit(this);
	}

	return null;
    }
}
