
abstract class AktorKit {
    protected String name;
    protected int serialnumber;
    protected Aktor[] aktoren;
    
    public abstract AktorKit allowed(Android android);

    public String toString() {
	return name;
    }
}
