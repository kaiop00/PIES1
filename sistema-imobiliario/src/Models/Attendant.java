package Models;

public class Attendant extends User {
	private Boolean isAttendant;

	public Attendant(String name, String cpf, String email, String password, Boolean isAttendant) {
		super(name, cpf, email, password);
		this.isAttendant = true;
	}

	public Boolean getIsAttendant() {
		return isAttendant;
	}

	public void setIsAttendant(Boolean isAttendant) {
		this.isAttendant = isAttendant;
	}

}
