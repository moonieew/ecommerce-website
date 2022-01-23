package ShopTheThao.Model;

public class SizeModel {
	private int productId;
	private String size;
	private int quantity;
	private int status;
	
	
	
	
	
	@Override
	public String toString() {
		return "SizeModel [productId=" + productId + ", size=" + size + ", quantity=" + quantity + ", status=" + status
				+ "]";
	}
	public SizeModel() {
		super();
	}
	public SizeModel(int productId, String size, int quantity, int status) {
		super();
		this.productId = productId;
		this.size = size;
		this.quantity = quantity;
		this.status = status;
	}
	
	public SizeModel(int productId, String size, int quantity) {
		super();
		this.productId = productId;
		this.size = size;
		this.quantity = quantity;
	}
	
	public int getproductId() {
		return productId;
	}
	public void setproductId(int productId) {
		this.productId = productId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
