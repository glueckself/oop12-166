abstract class AktorKit {
    protected String name;
    protected int serialnumber;

    public abstract AktorKit allowed(Android android);

    public String toString() {
	return name;
    }
}
