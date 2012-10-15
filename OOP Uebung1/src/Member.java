import java.util.Date;

public class Member {
	private Person person;
	private Instrument instrument;
	private Date joinDate;
	private Date leftDate = null;
	
	public Member(Person person, Instrument instrument, Date joinDate) {
		standardConstructor(person,instrument,joinDate);
	}

	public Member(Person person, Instrument instrument, Date joinDate, Date leftDate) {
		standardConstructor(person,instrument,joinDate);
		this.leftDate = leftDate;
	}
	
	private void standardConstructor(Person person, Instrument instrument, Date joinDate) {
		this.person = person;
		this.instrument = instrument;
		this.joinDate = joinDate;
	}
	
	public Person getPerson() {
		return this.person;
	}
	
	public Instrument getInstrument() {
		return this.instrument;
	}
	
	public Date getJoinDate() {
		return this.joinDate;
	}
	
	public Date getLeftDate() {
		return this.leftDate;
	}

  public void setLeftDate(Date leftDate) {
    this.leftDate = leftDate;
  }
}
