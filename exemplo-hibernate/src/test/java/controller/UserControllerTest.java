package controller;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import br.ufc.pies.controller.UserController;
import br.ufc.pies.exceptions.InvalidCredentialsException;
import br.ufc.pies.exceptions.MissingCredentialsException;
import br.ufc.pies.exceptions.MissingDataException;
import br.ufc.pies.model.User;



public class UserControllerTest {

	private UserController controller;
	
	@Before
	public void setup(){
		controller = new UserController();
	}
	
	@Test(expected = MissingDataException.class)
	public void testShouldThrowsMissingDataExceptionWhenNameIsNotProvided() throws MissingDataException {
		//arrange
		String name = "";
		String cpf = "000.000.000-12";
		String email = "email@gmail.com";
		String password = "abc1234";
		boolean isManager = false;
		
		//act
		controller.register(name, cpf, email, password, isManager);
	}
	
	@Test(expected = MissingDataException.class)
	public void testShouldThrowsMissingDataExceptionWhenCpfIsNotProvided() throws MissingDataException {
		//arrange
		String name = "A1";
		String cpf = "";
		String email = "email@gmail.com";
		String password = "abc1234";
		boolean isManager = false;
		
		//act
		controller.register(name, cpf, email, password, isManager);
	}
	
	@Test(expected = MissingDataException.class)
	public void testShouldThrowsMissingDataExceptionWhenEmailIsNotProvided() throws MissingDataException {
		//arrange
		String name = "A1";
		String cpf = "000.000.000-32";
		String email = "";
		String password = "abc1234";
		boolean isManager = false;
		
		//act
		controller.register(name, cpf, email, password, isManager);
	}
	
	@Test(expected = MissingDataException.class)
	public void testShouldThrowsMissingDataExceptionWhenPasswordIsNotProvided() throws MissingDataException {
		//arrange
		String name = "A1";
		String cpf = "000.000.000-32";
		String email = "email@gmail.com";
		String password = "";
		boolean isManager = false;
		
		//act
		controller.register(name, cpf, email, password, isManager);
	}
	
	@Test
	public void testShouldRegisterANewAttendantSuccessfully() throws MissingDataException {
		//arrange
		String name = "A1";
		String cpf = "000.000.000-12";
		String email = "email@gmail.com";
		String password = "abc1234";
		boolean isManager = false;
		
		//act
		User attendant = controller.register(name, cpf, email, password, isManager);
		
		//assert
		assertEquals(false, attendant.isManager());
		assertEquals(name, attendant.getName());
		assertEquals(email, attendant.getEmail());
		assertEquals(cpf, attendant.getCpf());
		assertEquals(password, attendant.getPassword());
	}
	
	
	@Test
	public void testShouldLoginAsAttendantSuccessfully() throws InvalidCredentialsException, MissingCredentialsException {
		String email = "email@gmail.com";
		String password = "abc1234";	
		
		//act
		User user = controller.login(email, password);
		
		//assert		
		assertEquals(email, user.getEmail());
		assertEquals(false, user.isManager());
	}
	
	@Test
	public void testShouldLoginAsManagerSuccessfully() throws MissingCredentialsException, InvalidCredentialsException {
		String email = "manager@gmail.com";
		String password = "abc1234";
	
		//act
		User user = controller.login(email, password);
		
		//assert		
		assertEquals(email, user.getEmail());
		assertEquals(true, user.isManager());
	}
	
	@Test(expected = MissingCredentialsException.class)
	public void testShouldThrowsMissingCredentialExceptionWhenEmailIsNull() throws MissingCredentialsException, InvalidCredentialsException {
		String email = null;
		String password = "abc1234";
	
		//act
		controller.login(email, password);
	}
	
	@Test(expected = MissingCredentialsException.class)
	public void testShouldThrowsMissingCredentialExceptionWhenPasswordIsNull() throws MissingCredentialsException, InvalidCredentialsException {
		String email = "email@gmail.com";
		String password = null;
	
		//act
		controller.login(email, password);
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testShouldThrowsInvalidCredentialExceptionWhenWrongEmailIsProvided() throws InvalidCredentialsException, MissingCredentialsException {
		String email = "wrongemail@gmail.com";
		String password = "1234abcd";
	
		//act
		controller.login(email, password);
	}
}
