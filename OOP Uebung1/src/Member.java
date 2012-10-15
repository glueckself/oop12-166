import java.util.Date;

public class Member {
	private Person person;
	private String instrument;
	private Date joinDate;
	private Date leftDate;
	
	public Member(Person person, String instrument, Date joinDate) {
		stdConstructor(person,instrument,joinDate);
	}
	public Member(Person person, String instrument, Date joinDate, Date leftDate) {
		stdConstructor(person,instrument,joinDate);
		this.leftDate = leftDate;
	}
	
	private void stdConstructor(Person person, String instrument, Date joinDate) {
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
