/**
 * Android
 */

abstract class Android {
    protected String name;
    protected int serialnumber;    
    protected Skin skin;
    protected Software software;
    protected AktorKit kit;

    /**
     * Characteristics of an android represented as a String
     * @return String Characteristics of an android
     */
    public String toString() {
    	return (Integer.toString(serialnumber)+" "+
    			name+" "+
    			skin.toString()+" "+
    			software.toString()+" "+
    			kit.toString());
    }
    
    /**
     * When the android is sold, all of it's parts are encoded with it's
     * serialnumber
     * @param serial Serialnumber used to encode parts
     */
    public void encode(int serial) {
        serialnumber = serial;
        skin.serialnumber = serialnumber;
        software.serialnumber = serialnumber;
        kit.serialnumber = serialnumber;
    }
    
    /**
     * Check if android is allowed to change it's type
     * @param android Android to check
     */
    public abstract Android modify(Android android);
    
    public Android modify(Bauarbeiter bauarbeiter) {
        return null;
    }
    public Android modify(Gesellschafter gesellschafter) {
        return null;
    }
    public Android modify(Hilfskraft hilfskraft) {
        return null;
    }
    public Android modify(Kaempfer kaempfer) {
        return null;
    }
    public Android modify(Leibwaechter leibwaechter) {
        return null;
    }
    public Android modify(Objektbewacher objektbewacher) {
        return null;
    }
    public Android modify(ServiceTechniker servicetechniker) {
        return null;
    }
    public Android modify(Transportarbeiter transportarbeiter) {
        return null;
    }
}
