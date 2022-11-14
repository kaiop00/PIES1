package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Attendant;

class AttendantTest {

	@Test
	void testAttendantTrue() {
		Attendant atd = new Attendant("Jose","08656743425","email@email.com","senha123",true);
		assertEquals(true, atd.getIsAttendant());
	}
	
	@Test
	void testAttendantFalse() {
		Attendant atd = new Attendant("Italo","08688743425","email@email.com","senha123",false);
		assertEquals(false, atd.getIsAttendant());
	}
	
	@Test
	void testSetIsAttedant() {
		Attendant atd = new Attendant("Joao","08688741225","email@email.com","senha123",false);
		atd.setIsAttendant(true);
		assertEquals(true, atd.getIsAttendant()); 
	}
	
	@Test
	void testAttendantGetName() {
		Attendant atd = new Attendant("Joao","08688741225","email@email.com","senha123",false);
		assertEquals("Joao",atd.getName());
	}

}
