package cards;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class GuestCard extends Card {
//	private Calendar dateCreated;
	private Calendar dateExpired;
	
	public GuestCard(String firstName, String lastName) {
		super(firstName, lastName, "9999");
//		dateCreated = new GregorianCalendar();
		dateExpired = new GregorianCalendar();
		dateExpired.add(Calendar.WEEK_OF_YEAR, 1);
		
	}

	@Override
	public boolean checkPin(String pin) {
		Calendar timeOfCardCheck = new GregorianCalendar();
		if(isSuspended() == false){
			return dateExpired.after(timeOfCardCheck) && pin.contentEquals(pinCode);
			
		}else{
			return false;
		}
	}
	
	//methods for testing only
	public boolean setTimeCheckPin(int weeksToAdd, String pin) {
		Calendar timeOfCardCheck = new GregorianCalendar();
		timeOfCardCheck.add(Calendar.WEEK_OF_YEAR, weeksToAdd);
		if(isSuspended() == false){
			return dateExpired.after(timeOfCardCheck) && pin.contentEquals(pinCode);
			
		}else{
			return false;
		}
	}
	
}
