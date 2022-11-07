package Models;

public abstract class  User {
	private int id;
	private String name;	
	private String cpf;
	private String email;
	private String password;
	
	public User(String name, String cpf, String email, String password) {
		this.setName(name);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setPassword(password);
		this.id = id++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", cpf=" + cpf + ", email=" + email + "]";
	}
	
	
	
};