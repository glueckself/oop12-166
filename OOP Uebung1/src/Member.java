import java.util.Calendar;
import java.util.Date;

public class Member {
	private String name;
	private String phone;
	private String instrument;
	private Date joinDate;
	private Date leftDate;
	
	public Member(String name, String phone, String instrument, Date joinDate) {
		standardConstructor(name,phone,instrument,joinDate);
	}
	public Member(String name, String phone, String instrument, Date joinDate, Date leftDate) {
		standardConstructor(name,phone,instrument,joinDate);
		this.leftDate = leftDate;
	}
	
	private void standardConstructor(String name, String phone, String instrument, Date joinDate) {
		this.name = name;
		this.phone = phone;
		this.instrument = instrument;
		this.joinDate = joinDate;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
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
