package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Client;

class UserTest {

	
	@Test
	void testGetNameUser() {
		Client client = new Client("Italo","45789125357","email@gmail.com","senha123");
		assertEquals("Italo",client.getName());
	}
	
	@Test
	void testSetNameUserVazio() {
		Client client = new Client();
		client.setName("");
		assertFalse(client.getName());
	}
	
	@Test
	void testGetCpfUser() {
		Client client = new Client("Italo","45789125357","email@gmail.com","senha123");
		assertEquals("45789125357",client.getCpf());
	}
	
	@Test
	void testSetCpfUserVazio() {
		Client client = new Client();
		client.setCpf("");
		assertFalse(client.getCpf());
	}
	
	@Test
	void testGetEmailUser() {
		Client client = new Client("Italo","45789125357","email@gmail.com","senha123");
		assertEquals("email@gmail.com",client.getEmail());
	}
	
	@Test
	void testSetEmailUserVazio() {
		Client client = new Client();
		client.setEmail("");
		assertFalse(client.getEmail());
	}
	
	@Test
	void testGetSenhaUser() {
		Client client = new Client("Italo","45789125357","email@gmail.com","senha123");
		assertEquals("senha123",client.getSenha());
	}
	
	@Test
	void testSetSenhaUserVazio() {
		Client client = new Client();
		client.setSenha("");
		assertFalse(client.getSenha());
	}

}
