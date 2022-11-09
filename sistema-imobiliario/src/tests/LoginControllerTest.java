
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.*;

public class LoginControllerTest {
 
	
	private Client cli;
	
	//Adicionar Cliente e retornar
	@Test
	public void testeAdicionarNome() {
		cli.setNome("Italo");
		assertEquals("Italo", cli.getNome());
	}
	
	@Test
	//Impedir adicionar nome vazio "" no login
	public void testeAdicionarNomeVazio() {
		assertFalse(cli.setNome(""));
	}
	
	@Test
	//Impedir adicionar nome vazio null
	public void testeAdicionarNomeVazioNull() {
		assertFalse(cli.setNome(null));
	}
	
	@Test
	//Verificar Email
	public void verificaSeEmailEValido(String email) {
        assertTrue(Email.validar(email));
   	
}
