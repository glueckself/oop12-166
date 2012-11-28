/**
 * AktorKit12kW
 */

class AktorKit12kW extends AktorKit {
    public AktorKit12kW() {
	name = "Aktor Kit 12kW";
	aktoren = new Aktor[10];
	aktoren[0] = new Aktor5kW();
	aktoren[1] = new Aktor5kW();
	aktoren[2] = new Aktor2kW();
    }

    public AktorKit allowed(Android android) {
	if(android.software.zertifikat != null) {
	    return android.software.zertifikat.allowedKit(this);
	}

	return null;
    }
}
