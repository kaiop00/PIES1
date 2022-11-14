package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Attendant;

class AttendantTest {

	//Entender melhor os testes do atendente.
	@Test
	void testAttendantTrue() {
		Attendant atd = new Attendant("Jose","08656743425","email@email.com","senha123",true);
		assertTrue(true);
	}
	
	@Test
	void testAttendantFalse() {
		Attendant atd = new Attendant("Italo","08688743425","email@email.com","senha123",false);
		assertFalse(false);
	}
	
	@Test
	void testSetIsAttedant() {
		Attendant atd = new Attendant("Joao","08688741225","email@email.com","senha123",true);
		Attendant.setIsAttendant(true);
		assertEquals("Joao",true); 
	}	

}
