package cards;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class GuestCard extends Card {
//	private Calendar dateCreated;
	private Calendar dateExpired;
	
//	didn't feel it to be necessary to put pin as an argument in the constructor, due to guest cards always having the pin 9999
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
	
	//method for testing only, identical to checkPin() except for a way to set time to desired
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
