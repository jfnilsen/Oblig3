package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import cards.Card;
import cards.EmployeeCard;
import cards.GuestCard;

public class CardTests {
	//------------------------------------------------------
	//--------------------Employee tests--------------------
	//------------------------------------------------------
	
			//----------General card tests----------
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
		assertEquals("Name: " + "Per Robert" + " Pincode: " 
	+ "1234" + " CardNumber: "+ card.getCardNumber() + " Cardsuspended: " + "false\n", card.toString());
	}
			//----------Employee card specific tests----------
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
	public void checkPin_works_at0600_Employee_WrongPin(){
		EmployeeCard card2 = new EmployeeCard("Per", "Pak", "1111");
		assertFalse(card2.setTimeCheckPin("1234", 6, Calendar.MONDAY));
	}
	@Test
	public void checkPin_works_at0700_Employee(){
		EmployeeCard card2 = new EmployeeCard("Per", "Pak", "1111");
		assertTrue(card2.setTimeCheckPin("1111", 7, Calendar.MONDAY));
		assertTrue(card2.setTimeCheckPin("1234", 7, Calendar.MONDAY));
	}
	@Test
	public void checkPin_works_at0700_Employee_NoPin(){
		EmployeeCard card2 = new EmployeeCard("Per", "Pak", "1111");
		assertTrue(card2.setTimeCheckPin("", 7, Calendar.MONDAY));
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
	public void setFirstName_works_Employee() {
		EmployeeCard card = new EmployeeCard("Per", "Pak", "2222");
		card.setFirstName("Pål");
		assertEquals("Pål", card.getFirstName());
	}
	@Test
	public void setLastName_works_Employee() {
		EmployeeCard card = new EmployeeCard("Per", "Pak", "2222");
		card.setLastName("Knutsen");
		assertEquals("Knutsen", card.getLastName());
	}
	@Test
	public void setFullName_works_Employee() {
		EmployeeCard card = new EmployeeCard("Per", "Pak", "2222");
		card.setFullName("Knut Knutsen");
		assertEquals("Knut Knutsen", card.getFullName());
	}
	
	//---------------------------------------------------
	//--------------------Guest tests--------------------
	//---------------------------------------------------
	
			//----------General card tests----------
	@Test
	public void cardConstructor_works_Guest() {
		Card card = new GuestCard("Tove", "Johan");
		assertNotNull(card);
		GuestCard card2 = new GuestCard("Tove", "Johan");
		assertNotNull(card2);
	}
	@Test
	public void getName_works_Guest(){
		Card card = new GuestCard("Per", "Robert");
		assertEquals("Per Robert", card.getName());
		Card card2 = new GuestCard("Peer", "Robert");
		assertEquals("Peer Robert", card2.getName());
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
		assertEquals("Name: " + "Per Robert" + " Pincode: " 
				+ "9999" + " CardNumber: "+ card.getCardNumber() + " Cardsuspended: " + "false\n", card.toString());
	}
			//----------Guest card specific tests----------
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
	//---------------------------------------------------------
	//--------------------Compare and Clone--------------------
	//---------------------------------------------------------
	
	@Test
	public void sortingTest_using_CompareTo() {
		ArrayList<Card> cardList = new ArrayList<>();
		Card card1 = new GuestCard("Bbert", "Askeladd");
		Card card2 = new GuestCard("Abert", "Basskeladd");
		Card card3 = new EmployeeCard("Abert", "Askeladd", "1234");
		Card card4 = new EmployeeCard("Bcert", "Askeladd", "1234");
		Card card5 = new EmployeeCard("Abert", "Baskeladd", "1234");
		Card card6 = new GuestCard("Abert", "Basskeladd");
		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);
		cardList.add(card6);
		
		
		Collections.sort(cardList);
		
		for(int i = 1; i < cardList.size(); i++){
			assertTrue(cardList.get(i-1).compareTo(cardList.get(i)) <= 0);
		}
	}
	@Test
	public void cloneTest() {
		Card card1 = new EmployeeCard("Abert", "Askeladd", "1234");
		Card card2;
		try {
			card2 = (Card) card1.clone();
			assertEquals(card1.toString(), card2.toString());
			assertEquals("Abert", ((EmployeeCard)card2).getFirstName());
			assertEquals("Askeladd", ((EmployeeCard)card2).getLastName());
			assertEquals("Abert Askeladd", ((EmployeeCard)card2).getFullName());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}
	
}
