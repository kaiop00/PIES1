package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Client;

class ClientTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	void testGetName() {
		Client client = new Client("Jose","000000000","email@email.com","00000","00000");
		assertEquals("Jose",client.getName());
	}
	
	void testGetCPF() {
		Client client = new Client("Jose","000000000","email@email.com","00000","00000");
		assertEquals("000000000",client.getCpf());
	}

}
