package ShopTheThao.Model;

public class CartDetailModel {
	private int productid;
	private String size;
	private int cartid;
	private double price;
	private int quantity;
	private ProductModel productmodel;
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "CartDetailModel [productid=" + productid + ", size=" + size + ", cartid=" + cartid + ", price=" + price
				+ ", quantity=" + quantity + ", productmodel=" + productmodel + "]";
	}
	public CartDetailModel(int productid, String size, int cartid, double price, int quantity,
			ProductModel productmodel) {
		super();
		this.productid = productid;
		this.size = size;
		this.cartid = cartid;
		this.price = price;
		this.quantity = quantity;
		this.productmodel = productmodel;
	}
	public CartDetailModel(int productid, String size, int cartid, double price, int quantity) {
		super();
		this.productid = productid;
		this.size = size;
		this.cartid = cartid;
		this.price = price;
		this.quantity = quantity;
	}
	public CartDetailModel() {
		super();
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductModel getProductmodel() {
		return productmodel;
	}
	public void setProductmodel(ProductModel productmodel) {
		this.productmodel = productmodel;
	}
	
	
	





	
	
	
}
