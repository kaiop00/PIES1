package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Client;

class ClientTest {
	
	@Test
	void testGetName() {
		Client client = new Client("Jose","000000000","email@email.com","00000","00000");
		assertEquals("Jose",client.getName());
	}
	
	@Test
	void testGetCPF() {
		Client client = new Client("Jose","000000000","email@email.com","00000","00000");
		assertEquals("000000000",client.getCpf());
	}
	
	@Test
	void testGetEmail() {
		Client client = new Client("Jose","000000000","email@email.com","00000","00000");
		assertEquals("email@email.com",client.getEmail());
	}
	
	@Test
	void testGetAddress() {
		Client client = new Client("Jose","000000000","email@email.com","Rua X, 321","0000");
		assertEquals("Rua X, 321", client.getAddress());
	}
	
	@Test
	void testGetPhone() {
		Client client = new Client("Jose","000000000","email@email.com","Rua X, 321","0000");
		assertEquals("0000",client.getPhone());
	}
	
	@Test
	void testSetName() {
		Client client = new Client("Jose","000000000","email@email.com","Rua X, 321","0000");
		client.setName("Joao");
		assertEquals("Joao",client.getName()); 
	}
	
	@Test
	void testSetCpf() {
		Client client = new Client("Jose","000000000","email@email.com","Rua X, 321","0000");
		client.setCpf("11111111111");
		assertEquals("11111111111",client.getCpf()); 
	}
	
	@Test
	void testSetEmail() {
		Client client = new Client("Jose","000000000","email@email.com","Rua X, 321","0000");
		client.setEmail("email@email.com");
		assertEquals("email@email.com",client.getEmail()); 
	}
	
	@Test
	void testSetAddress() {
		Client client = new Client("Jose","000000000","email@email.com","Rua X, 321","0000");
		client.setAdress("Av Maria, 1000");
		assertEquals("Av Maria,1000",client.getAddress()); 
	}
	
	@Test
	void testSetPhone() {
		Client client = new Client("Jose","000000000","email@email.com","Rua X, 321","0000");
		client.setPhone("1111111111");
		assertEquals("1111111111",client.getPhone()); 
	}


}
