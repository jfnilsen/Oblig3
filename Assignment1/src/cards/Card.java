package cards;

public abstract class Card implements Comparable<Card>, Cloneable {
	protected String firstName;
	protected String lastName;
	protected String pinCode;
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
		String returnString = "Name: " + getName() + " Pincode: " 
	+ pinCode + " CardNumber: "+ cardNumber + " Cardsuspended: " + cardSuspended+"\n" ;
		return returnString;
		
	}
	public void suspend() {
		cardSuspended = true;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	
	public abstract boolean checkPin(String pin);
	
	@Override
	public int compareTo(Card card){
		if(this.lastName != card.lastName){
			return this.lastName.compareTo(card.lastName);
		}else{
			return this.firstName.compareTo(card.firstName);
		}
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
}
