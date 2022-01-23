package ShopTheThao.Service.Implement;

import java.util.List;

import ShopTheThao.DAO.CategoryDAO;
import ShopTheThao.DAO.Implement.CategoryDAOImpl;
import ShopTheThao.Model.CategoryModel;
import ShopTheThao.Service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDAO categoryDAO = new CategoryDAOImpl();
	@Override
	public void insert(CategoryModel category) {
		categoryDAO.insert(category);
		
	}

	@Override
	public void edit(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CategoryModel category) {
		categoryDAO.delete(category);
		
	}

	@Override
	public List<CategoryModel> getAllCategory() {
		return categoryDAO.getAllCategory();
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDAO.get(id);
	}

}
