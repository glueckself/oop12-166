class AktorKit4kW extends AktorKit {
    private Aktor aktor2kW_1;
    private Aktor aktor2kW_2;

    public AktorKit4kW() {
	name = "Aktor Kit 4kW";
	this.aktor2kW_1 = new Aktor2kW();
	this.aktor2kW_2 = new Aktor2kW();
    }

    public AktorKit allowed(Android android) {
	if(android.software.zertifikat != null) {
	    return android.software.zertifikat.allowedKit(this);
	}
	
	return null;
    }
}
