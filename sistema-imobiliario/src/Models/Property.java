package Models;

public class Property {
	private String id;
	private String adress;
	private String area;
	private String value;
	private String room;
	private String garage;
	private String isLocate;
	
	public Property() {}
	
	public Property(String id, String adress, String area, String value, String room, String garage, String isLocate) {
		this.id = id;
		this.adress = adress;
		this.area = area;
		this.value = value;
		this.room = room;
		this.garage = garage;
		this.isLocate = isLocate;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAddress() {
		return adress;
	}
	
	public void setAddress(String adress) {
		this.adress = adress;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getRoom() {
		return room;
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	
	public String getIsLocate() {
		return isLocate;
	}
	
	public void setIsLocate(String isLocate) {
		this.isLocate = isLocate;
	}
}
