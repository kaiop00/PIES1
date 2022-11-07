package Models;

public class Manager extends User {
	private Boolean isManager;

	public Manager(String name, String cpf, String email, String password) {
		super(name, cpf, email, password);
		this.isManager = true;
	}
	
	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}
	
}
