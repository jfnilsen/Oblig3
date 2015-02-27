
public abstract class Card {
	protected String firstName;
	protected String lastName;
	protected String pinCode;
	private int accessCode;
	protected static int cardsCreated;
	protected int cardNumber;
	protected boolean cardSuspended;
	
	public Card(String firstName, String lastName, String pinCode){
		this.firstName = firstName;
		this.lastName = lastName;
		this.pinCode = pinCode;
		cardSuspended = false;
		cardsCreated++; 
		cardNumber = cardsCreated;
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
