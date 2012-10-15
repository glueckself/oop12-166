import java.util.Date;

public class Member {
	private Person person;
	private String instrument;
	private Date joinDate;
	private Date leftDate;
	
	public Member(Person person, String instrument, Date joinDate) {
		standardConstructor(person,instrument,joinDate);
	}
	public Member(Person person, String instrument, Date joinDate, Date leftDate) {
		standardConstructor(person,instrument,joinDate);
		this.leftDate = leftDate;
	}
	
	private void standardConstructor(Person person, String instrument, Date joinDate) {
		this.person = person;
		this.instrument = instrument;
		this.joinDate = joinDate;
	}
	
	public Person getPerson() {
		return this.person;
	}
	
	public String getInstrument() {
		return this.instrument;
	}
	
	public Date getJoinDate() {
		return this.joinDate;
	}
	
	public Date getLeftDate() {
		return this.leftDate;
	}
}
