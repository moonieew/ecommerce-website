package ShopTheThao.Model;

public class ShipModel {
	private int id;
	private String cachShip;
	private double price;
	public ShipModel(String cachShip, double price) {
		super();
		this.cachShip = cachShip;
		this.price = price;
	}
	public ShipModel() {
		super();
	}
	public ShipModel(int id, String cachShip, double price) {
		super();
		this.id = id;
		this.cachShip = cachShip;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCachShip() {
		return cachShip;
	}
	public void setCachShip(String cachShip) {
		this.cachShip = cachShip;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
