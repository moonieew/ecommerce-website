package ShopTheThao.Model;

public class CategoryModel {
	private int id;
	private String name;
	private int status;
	public CategoryModel(String name, int status) {
		super();
		this.name = name;
		this.status = status;
	}
	public CategoryModel() {
		super();
	}
	public CategoryModel(int id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
