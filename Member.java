import java.util.Calendar;
import java.util.Date;

public class Member {
	private String name;
	private String phone;
	private String instrument;
	private Date timestamp;
	
	public Member(String name, String phone, String instrument) {
		this.name = name;
		this.phone = phone;
		this.instrument = instrument;
		this.timestamp = Calendar.getInstance().getTime();
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
	
	public Date getTimestamp() {
		return this.timestamp;
	}
}
