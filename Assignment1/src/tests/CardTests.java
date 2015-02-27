package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Calendar;
import cards.Card;
import cards.EmployeeCard;
import cards.GuestCard;

public class CardTests {
	
	@Test
	public void cardConstructor_works_Employee(){
		 Card card = new EmployeeCard("Per", "Robert", "1234");
		 assertNotNull(card);
		 EmployeeCard card2 = new EmployeeCard("Per", "Robert", "1234");
		 assertNotNull(card2);
	}
	@Test
	public void getName_works_Employee(){
		 Card card = new EmployeeCard("Per", "Robert", "1234");
		 assertEquals("Per Robert", card.getName());
		 EmployeeCard card2 = new EmployeeCard("Per", "Robert", "1234");
		 assertEquals("Per Robert", card2.getName());
	}
	@Test
	public void isSuspended_returnsCorrect_Employee() {
		Card card = new EmployeeCard("Per", "Robert", "1234");
		assertFalse(card.isSuspended());
		card.suspend();
		assertTrue(card.isSuspended());
	}
	@Test
	public void toString_returnsCorrect_Employee() {
		Card card = new EmployeeCard("Per", "Robert", "1234");
		assertEquals("Name: " + "Per Robert" + "\nPincode: " 
	+ "1234" + "\nCardNumber: "+ card.getCardNumber() + "\nCardsuspended: " + "false", card.toString());
	}
	@Test
	public void checkPin_works_at1500_Employee(){
		EmployeeCard card = new EmployeeCard("Per", "Pak", "1234");
		assertTrue(card.setTimeCheckPin("1234", 15, Calendar.MONDAY));
	}
	@Test
	public void checkPin_works_at0600_Employee_RightPin(){
		EmployeeCard card2 = new EmployeeCard("Per", "Pak", "1111");
		assertTrue(card2.setTimeCheckPin("1111", 6, Calendar.MONDAY));
	}
	@Test
	public void checkPin_works_at0700_Employee(){
		EmployeeCard card2 = new EmployeeCard("Per", "Pak", "1111");
		assertTrue(card2.setTimeCheckPin("1111", 7, Calendar.MONDAY));
	}
	
	@Test
	public void checkPin_works_at1700_Employee_RightPin() {
		EmployeeCard card = new EmployeeCard("Per", "Pak", "2222");
		assertTrue(card.setTimeCheckPin("2222", 18, Calendar.MONDAY));
	}
	@Test
	public void checkPin_works_at1700_Employee_WrongPin() {
		EmployeeCard card = new EmployeeCard("Per", "Pak", "2222");
		assertFalse(card.setTimeCheckPin("1111",18, Calendar.MONDAY));
	}
	@Test
	public void cardConstructor_works_Guest() {
		Card card = new GuestCard("Tove", "Johan");
		assertNotNull(card);
		GuestCard card2 = new GuestCard("Tove", "Johan");
		assertNotNull(card2);
	}
	@Test
	public void checkPin_works_Guest_RightPin() {
		Card card = new GuestCard("Tove", "Johan");
		assertTrue(card.checkPin("9999"));
	}
	@Test
	public void checkPin_works_Guest_WrongPin() {
		Card card = new GuestCard("Tove", "Johan");
		assertFalse(card.checkPin("9991"));
	}
	@Test
	public void checkPin_works_Guest_AddOneWeek() {
		GuestCard card = new GuestCard("Tove", "Johan");
		assertFalse(card.setTimeCheckPin(1, "9999"));
	}
	@Test
	public void getName_works_Guest(){
		 Card card = new GuestCard("Per", "Robert");
		 assertEquals("Per Robert", card.getName());
		 Card card2 = new GuestCard("Per", "Robert");
		 assertEquals("Per Robert", card2.getName());
	}
	@Test
	public void isSuspended_returnsCorrect_Guest() {
		Card card = new GuestCard("Per", "Robert");
		assertFalse(card.isSuspended());
		card.suspend();
		assertTrue(card.isSuspended());
	}
	@Test
	public void toString_returnsCorrect_Guest() {
		Card card = new GuestCard("Per", "Robert");
		assertEquals("Name: " + "Per Robert" + "\nPincode: " 
	+ "9999" + "\nCardNumber: "+ card.getCardNumber() + "\nCardsuspended: " + "false", card.toString());
	}
	
}
