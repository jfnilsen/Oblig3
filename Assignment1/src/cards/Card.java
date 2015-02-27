package cards;

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
		++cardsCreated; 
		cardNumber = cardsCreated;
	}
	public String getName() {
		return firstName + " " + lastName;
		
	}
	public boolean isSuspended() {
		return cardSuspended;
		
	}
	
	@Override
	public String toString() {
		String returnString = "Name: " + getName() + "\nPincode: " 
	+ pinCode + "\nCardNumber: "+ cardNumber + "\nCardsuspended: " + cardSuspended ;
		return returnString;
		
	}
	public void suspend() {
		cardSuspended = true;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	
	public abstract boolean checkPin(String pin);
	
}
