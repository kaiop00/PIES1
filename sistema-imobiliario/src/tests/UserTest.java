package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Client;
import Models.User;

class UserTest {
//Pensar como fazer os testes de usuário
	
	@Test
	void testGetNameUser() {
		User usuario = new User("Italo","45789125357","email@gmail.com","senha123");
		assertEquals("Italo",usuario.getName());
	}
	
	//@Test
	//void testSetNameUserVazio() {
	//	User usuario = new Client();
	//	usuario.setName("");
	//	assertFalse(client.getName());
	//}
	
	@Test
	void testGetCpfUser() {
		User usuario = new User("Italo","45789125357","email@gmail.com","senha123");
		assertEquals("45789125357",usuario.getCpf());
	}
	
	//@Test
	//void testSetCpfUserVazio() {
	//	Client client = new Client();
	//	client.setCpf("");
	//	assertFalse(client.getCpf());
	//}
	
	@Test
	void testGetEmailUser() {
		User usuario = new User("Italo","45789125357","email@gmail.com","senha123");
		assertEquals("email@gmail.com",usuario.getEmail());
	}
	
	//@Test
	//void testSetEmailUserVazio() {
	//	Client client = new Client();
		//client.setEmail("");
		//assertFalse(client.getEmail());
	//}
	
	@Test
	void testGetSenhaUser() {
		User usuario = new User("Italo","45789125357","email@gmail.com","senha123");
		assertEquals("senha123",usuario.getPassword());
	}
	
	//@Test
	//void testSetSenhaUserVazio() {
		//Client client = new Client();
		//client.setSenha("");
		//assertFalse(client.getSenha());
	//}

}
