
public abstract class Card {
	private String firstName;
	private String lastName;
	private String pinCode;
	private int accessCode;
	static int cardsCreated;
	private int cardNumber;
	private boolean cardSuspended;
	
	public Card(String firstName, String lastName, String pinCode){
		this.firstName = firstName;
		this.lastName = lastName;
		this.pinCode = pinCode;
		cardsCreated++; 
		cardNumber = cardsCreated;
		cardSuspended = false;
	}
	public String getName() {
		return firstName + " " + lastName;
		
	}
	public boolean getSuspended() {
		return cardSuspended;
	}
	
	@Override
	public String toString() {
		String returnString = "Name: " + getName() + "/nPincode: " 
	+ pinCode + "/nCardNumber: "+ cardNumber + "/nCardsuspended: " + cardSuspended ;
		return returnString;
		
	}
	
	public abstract boolean checkPin(String pin);
}
