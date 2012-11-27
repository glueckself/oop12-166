abstract class Android {
	protected String name;
    protected int serialnumber;    
    protected Skin skin;
    protected Software software;
    protected SensorActorKit kit;
    public String toString() {
    	return (Integer.toString(serialnumber)+" "+
    			name+" "+
    			skin.toString()+" "+
    			software.toString()+" "/*+
    			kit.toString()*/);
    }
}
