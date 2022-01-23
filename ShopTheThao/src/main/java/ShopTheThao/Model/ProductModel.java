package ShopTheThao.Model;

public class ProductModel {
	private int id;
	private String name;
	private double price;
	private double salePrice;
	private int quantity;
	private String description;
	private String image;
	private String brandId;
	private int categoryId;
	private int userid;
	private int status;
	
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", price=" + price + ", salePrice=" + salePrice
				+ ", quantity=" + quantity + ", description=" + description + ", image=" + image + ", brandId="
				+ brandId + ", categoryId=" + categoryId + ", userid=" + userid + ", status=" + status + "]";
	}

	public ProductModel() {
		super();
	}
	
	public ProductModel(int id, String name, double price, double salePrice, int quantity, String description,
			String image, String brandId, int categoryId, int userid, int status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.userid = userid;
		this.status = status;
	}
	
	public ProductModel(String name, double price, double salePrice, int quantity, String description,
			String image, String brandId, int categoryId, int userid) {
		super();
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.userid = userid;
	}
	
	public ProductModel(int id, String name, double price, double salePrice, int quantity, String description,
			String image, String brandId, int categoryId, int userid) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.quantity = quantity;
		this.description = description;
		this.image = image;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
