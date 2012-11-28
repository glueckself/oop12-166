/**
 * AktorKit1kW
 */

class AktorKit1kW extends AktorKit {
    public AktorKit1kW() {
	name = "Aktor Kit 1kW";
	aktoren = new Aktor[10];
	aktoren[0] = new Aktor1kW();
    }

    public AktorKit allowed(Android android) {
	if(android.software.zertifikat != null) {
	    return android.software.zertifikat.allowedKit(this);
	}

	return null;
    }
}
