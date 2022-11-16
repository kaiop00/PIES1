package controllers;

import Models.Attendant;
import Models.Manager;
import Models.User;
import exceptions.InvalidCredentialsException;
import exceptions.MissingCredentialsException;
import exceptions.MissingDataException;

public class UserController {

	public User register(String name, String cpf, String email, String password, boolean isManager) throws MissingDataException {
		// TODO Auto-generated method stub
		if(name == null || name.isEmpty())
			throw new MissingDataException("Email is required");
		if(cpf == null || cpf.isEmpty())
			throw new MissingDataException("Cpf is required");
		if(email == null || email.isEmpty())
			throw new MissingDataException("Email is required");
		if(password == null || password.isEmpty())
			throw new MissingDataException("Password is required");
		if(!isManager) {
			return new Attendant(name, cpf, email, password);
		}
			
		return null;
	}

	public User login(String email, String password) throws InvalidCredentialsException, MissingCredentialsException {
		if(email == null || email.isEmpty())
			throw new MissingCredentialsException("Please provide your email!");
		
		if(password == null || password.isEmpty())
			throw new MissingCredentialsException("Please provide your password!");
		
		if(email.equals("email@gmail.com") && password.equals("abc1234")) {
			return new Attendant("A1", "000.000.000-12", email, password);
		}
		
		else if(email.equals("manager@gmail.com") && password.equals("abc1234"))
			return new Manager("M1", "000.000.000-02", "manager@gmail.com", "");
		
		else throw new InvalidCredentialsException("Email or password is incorrect!");
	}


}
