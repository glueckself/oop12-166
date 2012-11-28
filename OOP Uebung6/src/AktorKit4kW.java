class AktorKit4kW extends AktorKit {

    public AktorKit4kW() {
	name = "Aktor Kit 4kW";
	aktoren = new Aktor[10];
    aktoren[0] = new Aktor2kW();
    aktoren[1] = new Aktor2kW();
    }

    public AktorKit allowed(Android android) {
	if(android.software.zertifikat != null) {
	    return android.software.zertifikat.allowedKit(this);
	}
	
	return null;
    }
}
