package Models;

public class Client {
	private String name;
	private String cpf;
	private String email;
	private String address;
	private String phone;
	
	public Client(){}
	
	public Client(String name, String cpf, String email, String address, String phone) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAdress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Client [name=" + name + ", cpf=" + cpf + ", email=" + email + ", endereço=" + address + ", phone="
				+ phone + "]";
	}
	
	
	
}
