package cards;
import interfaces.Permanent;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class EmployeeCard extends Card implements Permanent {
	Calendar dateCreated;
	Calendar timeOfCardCheck;
	//assignment does not specify what these should be, initialized them to 0
	private double bonusConstant = 0;
	private double hourlyWage = 0;
	private double creditConstant = 0;
	
	public EmployeeCard(String firstName, String lastName, String pinCode) {
		super(firstName, lastName, pinCode);
		dateCreated = new GregorianCalendar();
	}

	@Override
	public boolean checkPin(String pin) {
		if(isSuspended() == true){
			timeOfCardCheck = new GregorianCalendar();

			if(isWorkTime(timeOfCardCheck)){
				return true;
			}else {
				return pin.contentEquals(pinCode);
			}
		}else{
			return false; 
		}
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
		return hourlyWage * creditConstant;
	}

	@Override
	public double calculateBonus() {
		Calendar timeOfCalculation = new GregorianCalendar();
		double years = (timeOfCalculation.getTimeInMillis() - dateCreated.getTimeInMillis())/(1000*60*60*24*365.25);
		return (int)years * bonusConstant;
	}

	//method for testing only, identical to checkPin() except for a way to set time to desired
	public boolean setTimeCheckPin(String pin, int time, final int dayOfWeek){
		if(isSuspended() == false){
			timeOfCardCheck = new GregorianCalendar();
			timeOfCardCheck.set(Calendar.HOUR_OF_DAY, time);
			timeOfCardCheck.set(Calendar.DAY_OF_WEEK, dayOfWeek);

			if(isWorkTime(timeOfCardCheck)){
				return true;
			}else{
				return pin.contentEquals(pinCode);
			}
		}else{
			return false; 
		}

	}


}
