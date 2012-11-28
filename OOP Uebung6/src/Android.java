abstract class Android {
	protected String name;
    protected int serialnumber;    
    protected Skin skin;
    protected Software software;
    protected AktorKit kit;
    public String toString() {
    	return (Integer.toString(serialnumber)+" "+
    			name+" "+
    			skin.toString()+" "+
    			software.toString()+" "+
    			kit.toString());
    }
    
    public void encode(int serial) {
        serialnumber = serial;
        skin.serialnumber = serialnumber;
        software.serialnumber = serialnumber;
        kit.serialnumber = serialnumber;
    }
    
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
