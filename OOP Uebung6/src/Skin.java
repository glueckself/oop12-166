abstract class Skin {
	protected String name;
	
    public abstract void allowed(Bediener bediener);
    public abstract void allowed(Schwerarbeiter schwerarbeiter);
    public abstract void allowed(Beschuetzer beschuetzer);
    
    public String toString() {
    	return name;
    }
}
