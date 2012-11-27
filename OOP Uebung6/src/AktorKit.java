abstract class AktorKit {
    protected String name;

    public abstract AktorKit allowed(Android android);

    public String toString() {
	return name;
    }
}
