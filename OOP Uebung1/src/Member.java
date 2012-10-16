import java.util.Date;

public class Member {
    private Person person;
    private Instrument instrument;
    private Date joinDate;
    private Date leftDate = null;
    
    public Member(Person person, Instrument instrument, Date joinDate) {
		stdConstructor(person,instrument,joinDate);
    }
    
    public Member(Person person, Instrument instrument, Date joinDate, Date leftDate) {
		stdConstructor(person,instrument,joinDate);
        this.leftDate = leftDate;
    }
    
	private void stdConstructor(Person person, Instrument instrument, Date joinDate) {
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
      if(this.joinDate == null) return null;
        return (Date)this.joinDate.clone();
    }
    
    public Date getLeftDate() {
      if(this.leftDate == null) return null;

        return (Date)this.leftDate.clone();
    }
    
    public void setLeftDate(Date leftDate) {
        this.leftDate = leftDate;
    }
}
