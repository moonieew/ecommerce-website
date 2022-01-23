package ShopTheThao.Model;

import java.util.List;



public class CartModel {
	private int id;
	private int quantity;
	private double grandTotal;
	private int userId;
	private List<CartDetailModel> listcartdetail;
	
	
	public CartModel() {
		super();
	}
	
	public CartModel(int id, int quantity, double grandTotal, int userId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.grandTotal = grandTotal;
		this.userId = userId;
	}

	public CartModel(int id, int quantity, double grandTotal, int userId, List<CartDetailModel> listcartdetail) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.grandTotal = grandTotal;
		this.userId = userId;
		this.listcartdetail = listcartdetail;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
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


	public List<CartDetailModel> getListcartdetail() {
		return listcartdetail;
	}


	public void setListcartdetail(List<CartDetailModel> listcartdetail) {
		this.listcartdetail = listcartdetail;
	}
	
	
	
	
}
