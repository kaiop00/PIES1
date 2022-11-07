package Models;

public class Property {
	private int id;
	private String adress;
	private Double area;
	private Double value;
	private int room;
	private int garage;
	private boolean isLocate;
	
	public Property(int id, String adress, Double area, Double value, int room, int garage) {
		super();
		this.id = id;
		this.adress = adress;
		this.area = area;
		this.value = value;
		this.room = room;
		this.garage = garage;
		this.isLocate = false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getGarage() {
		return garage;
	}
	public void setGarage(int garage) {
		this.garage = garage;
	}
	public int getIsLocate() {
		return isLocate;
	}
	public void setIsLocate(int isLocate) {
		this.isLocate = isLocate;
	}
}
