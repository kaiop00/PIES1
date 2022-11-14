package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Property;

class PropertyTest {

	//id, adress, area, value, room, garage
	@Test
	void testGetId() {
		Property prop = new Property(1,"Rua 1",2.0,300.00,1,1);
		assertEquals(1,prop.getId());
	}
	
	void testSetId() {
		Property prop = new Property(1,"Rua 2",2.0,300.00,1,1);
		prop.setId(2);
		assertEquals(2,prop.getId()); 
	}
	
	@Test
	void testGetAdress() {
		Property prop = new Property(1,"Rua 1",2.0,300.00,1,1);
		assertEquals("Rua 1", prop.getAdress());
	}
	
	void testSetAdress() {
		Property prop = new Property(1,"Rua 2",2.0,300.00,1,1);
		prop.setAdress("Rua 3");
		assertEquals("Rua 3", prop.getAdress()); 
	}
	
	@Test
	void testGetArea() {
		Property prop = new Property(1,"Rua 1",2.0,300.00,1,1);
		assertEquals(2.0, prop.getArea());
	}
	
	void testSetArea() {
		Property prop = new Property(1,"Rua 2",2.0,300.00,1,1);
		prop.setArea(3.0);
		assertEquals(3.0, prop.getArea()); 
	}
	
	@Test
	void testGetValue() {
		Property prop = new Property(1,"Rua 1",2.0,300.00,1,1);
		assertEquals(300.0, prop.getValue());
	}
	
	void testSetValue() {
		Property prop = new Property(1,"Rua 2",2.0,300.00,1,1);
		prop.setValue(340.0);
		assertEquals(340.0,prop.getValue()); 
	}
	
	@Test
	void testGetRoom() {
		Property prop = new Property(1,"Rua 1",2.0,300.00,1,1);
		assertEquals(1, prop.getRoom());
	}
	
	void testSetRoom() {
		Property prop = new Property(1,"Rua 2",2.0,300.00,1,1);
		prop.setRoom(3);
		assertEquals(3, prop.getRoom()); 
	}
	
	@Test
	void testGetGarage() {
		Property prop = new Property(1,"Rua 1",2.0,300.00,1,2);
		assertEquals(2, prop.getGarage());
	}
	
	void testSetGarage() {
		Property prop = new Property(1,"Rua 2",2.0,300.00,1,1);
		prop.setGarage(3);
		assertEquals(3, prop.getGarage()); 
	}

}
