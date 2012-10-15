
public class Person {
    private String name;
    private String phone;
    
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getphone() {
        return this.phone;
    }
	
	public String toString() {
		return (this.name+", Telefon "+this.phone);
	}
}
