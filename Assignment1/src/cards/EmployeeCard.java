package cards;
import interfaces.Permanent;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class EmployeeCard extends Card implements Permanent {
	Calendar dateCreated;
	Calendar timeOfCardCheck;

	public EmployeeCard(String firstName, String lastName, String pinCode) {
		super(firstName, lastName, pinCode);
		dateCreated = new GregorianCalendar();
	}

	@Override
	public boolean checkPin(String pin) {
		if(isSuspended() == false){
			timeOfCardCheck = new GregorianCalendar();

			if(isWorkTime(timeOfCardCheck)){
				return true;
			}else {
				return checkPinCode(pin);
			}
		}else{
			return false; 
		}
	}
	private boolean checkPinCode(String pin){
		return (pin.contentEquals(pinCode));

	}
	private boolean isWorkTime(Calendar timeOfCardCheck){
		return (timeOfCardCheck.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && 
				timeOfCardCheck.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) &&
				timeOfCardCheck.get(Calendar.HOUR_OF_DAY) >= 7 &&
				timeOfCardCheck.get(Calendar.HOUR_OF_DAY) < 17;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setFullName(String fullName) {
		String[] nameParts = fullName.split(" ");
		this.firstName = nameParts[0];
		this.lastName = nameParts[1];
	}

	@Override
	public String getFullName() {
		return firstName + " " + lastName;
		
	}
	@Override
	public double calculateCredit() {
		return 0;
	}

	@Override
	public double calculateBonus() {
		return 0;
	}

	//methods for testing only
	public boolean setTimeCheckPin(String pin, int time, final int dayOfWeek){
		if(isSuspended() == false){
			timeOfCardCheck = new GregorianCalendar();
			timeOfCardCheck.set(Calendar.HOUR_OF_DAY, time);
			timeOfCardCheck.set(Calendar.DAY_OF_WEEK, dayOfWeek);

			if(isWorkTime(timeOfCardCheck)){
				return true;
			}else{
				return checkPinCode(pin);
			}
		}else{
			return false; 
		}

	}


}
