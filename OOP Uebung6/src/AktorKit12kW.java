class AktorKit12kW extends AktorKit {
    private Aktor aktor5kW_1;
    private Aktor aktor5kW_2;
    private Aktor aktor2kW;

    public AktorKit12kW() {
	name = "Aktor Kit 12kW";
	this.aktor5kW_1 = new Aktor5kW();
	this.aktor5kW_2 = new Aktor5kW();
	this.aktor2kW = new Aktor2kW();
    }

    public AktorKit allowed(Android android) {
	if(android.software.zertifikat != null) {
	    return android.software.zertifikat.allowedKit(this);
	}

	return null;
    }
}
