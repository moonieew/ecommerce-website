package ShopTheThao.DAO;

import java.util.List;

import ShopTheThao.Model.CategoryModel;

public interface CategoryDAO {
	void insert(CategoryModel category); 
	void edit(CategoryModel category); 
	void delete(CategoryModel category);
	List<CategoryModel> getAllCategory(); 
	CategoryModel get(int id); 
}
