package ShopTheThao.DAO;

import java.util.List;

import ShopTheThao.Model.ProductModel;

public interface ProductDAO {
	void insert(ProductModel product); 

	void edit(ProductModel product); 

	void delete(ProductModel product); 

	List<ProductModel> search(String productName);
	
	List<ProductModel> getAllProduct(int pageNumber, int rowsOfPage, int userid);

	List<ProductModel> getAllByPaging(int pageNumber, int rowsOfPage); 

	List<ProductModel> getByCategoryAndPaging(int pageNumber, int rowsOfPage, int categoryId); 
																								

	List<ProductModel> getBySearchAndPaging(int pageNumber, int rowsOfPage, String search); // Phân trang theo tìm kiếm
	
	List<ProductModel> getByCategoryId(int id); 

	ProductModel get(int id); 
	
	int countAll(int userid);

	ProductModel getProductByID(int productid, int userid);
	
	int countAll();
	
	int countByCategory(int categoryId); 
	
	int countBySearch(String search);
	
	ProductModel getTop1();

	List<ProductModel> getTop4();

	int getProductID(String name, int userid);
}
