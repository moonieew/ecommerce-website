package ShopTheThao.Model;

import java.sql.Date;

public class OrderModel {
	private int id;
	private Date createAt;
	private Date completeAt;
	private int status;
	private int quantity;
	private int shipId;
	private double total;
	private double grandTotal;
	private int userId;
	public OrderModel() {
		super();
	}
	public OrderModel(int id, Date createAt, Date completeAt, int status, int quantity, int shipId, double total,
			double grandTotal, int userId) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.completeAt = completeAt;
		this.status = status;
		this.quantity = quantity;
		this.shipId = shipId;
		this.total = total;
		this.grandTotal = grandTotal;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getCompleteAt() {
		return completeAt;
	}
	public void setCompleteAt(Date completeAt) {
		this.completeAt = completeAt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getShipId() {
		return shipId;
	}
	public void setShipId(int shipId) {
		this.shipId = shipId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
