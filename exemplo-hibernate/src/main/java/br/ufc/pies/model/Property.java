package br.ufc.pies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private float area;
	private int rooms;
	private String address;
	private boolean hasGarage;
	private float value;
	private boolean isLocate;
	
	@ManyToOne
    @JoinColumn(name="client_id", nullable=true)
    private Client client;
	
	public Property() {
		
	}
	
	public Property(float area, int rooms, String address, boolean hasGarage, float value, boolean isLocate) {
		this.area = area;
		this.rooms = rooms;
		this.address = address;
		this.hasGarage = hasGarage;
		this.value = value;
		this.isLocate = isLocate;
	}

	public boolean isLocate() {
		return isLocate;
	}

	public void setIsLocate(boolean isLocate) {
		this.isLocate = isLocate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean hasGarage() {
		return hasGarage;
	}

	public void setHasGarage(boolean hasGarage) {
		this.hasGarage = hasGarage;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
