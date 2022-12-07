package br.ufc.pies.model;

public class Attendant extends User {
	private Boolean isAttendant;

	public Attendant(String name, String cpf, String email, String password) {
		super(name, cpf, email, password);
		this.setIsManager(false);
	}

	public Boolean getIsAttendant() {
		return isAttendant;
	}

	public void setIsAttendant(Boolean isAttendant) {
		this.isAttendant = isAttendant;
	}

}

