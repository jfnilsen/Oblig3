import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class GuestCard extends Card {
//	private Calendar dateCreated;
	private Calendar dateExpired;
	
	public GuestCard(String firstName, String lastName, String pinCode) {
		super(firstName, lastName, "9999");
//		dateCreated = new GregorianCalendar();
		dateExpired = new GregorianCalendar();
		dateExpired.add(Calendar.WEEK_OF_YEAR, 1);
		
	}

	@Override
	public boolean checkPin(String pin) {
		if(getSuspended() == false){
			return dateExpired.after(new Date());
			
		}else{
			return false;
		}
	}
	
}
