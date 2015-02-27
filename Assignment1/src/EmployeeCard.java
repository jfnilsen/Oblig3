import java.util.Calendar;
import java.util.GregorianCalendar;


public class EmployeeCard extends Card {
	Calendar dateCreated;
	Calendar timeOfCardCheck;
	
	public EmployeeCard(String firstName, String lastName, String pinCode) {
		super(firstName, lastName, pinCode);
		dateCreated = new GregorianCalendar();
	}

	@Override
	public boolean checkPin(String pin) {
		if(getSuspended() == false){
			
		timeOfCardCheck = new GregorianCalendar();
		if((timeOfCardCheck.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && 
				timeOfCardCheck.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) &&
				timeOfCardCheck.get(Calendar.HOUR_OF_DAY) > 7 &&
				timeOfCardCheck.get(Calendar.HOUR_OF_DAY) < 17){
			return true;
		}else if(pin == pinCode){
			return true;
		}
		else{
		return false;
		}
		}else{
			return false; 
		}
	}

}
