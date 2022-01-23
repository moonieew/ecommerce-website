package ShopTheThao.Service.Implement;

import java.util.List;

import ShopTheThao.DAO.ProductDAO;
import ShopTheThao.DAO.Implement.ProductDAOImpl;
import ShopTheThao.Model.ProductModel;
import ShopTheThao.Service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDAO productDao = new ProductDAOImpl();

	@Override
	public void insert(ProductModel product) {
		productDao.insert(product);
		
	}

	@Override
	public void edit(ProductModel product) {
		productDao.edit(product);
	}

	@Override
	public void delete(ProductModel product) {
		productDao.delete(product);
	}

	@Override
	public List<ProductModel> search(String productName) {
		return productDao.search(productName);
	}

	@Override
	public List<ProductModel> getAllByPaging(int pageNumber, int rowsOfPage) {
		return productDao.getAllByPaging(pageNumber, rowsOfPage);
	}

	@Override
	public List<ProductModel> getByCategoryAndPaging(int pageNumber, int rowsOfPage, int categoryId) {
		return productDao.getByCategoryAndPaging(pageNumber, rowsOfPage, categoryId);
	}

	@Override
	public List<ProductModel> getBySearchAndPaging(int pageNumber, int rowsOfPage, String search) {
		return productDao.getBySearchAndPaging(pageNumber, rowsOfPage, search);
	}

	@Override
	public List<ProductModel> getByCategoryId(int id) {
		return productDao.getByCategoryId(id);
	}

	@Override
	public ProductModel get(int id) {
		return productDao.get(id);
	}

	@Override
	public int countAll() {
		return productDao.countAll();
	}

	@Override
	public int countByCategory(int categoryId) {
		return productDao.countByCategory(categoryId);
	}

	@Override
	public int countBySearch(String search) {
		return productDao.countBySearch(search);
	}

	@Override
	public ProductModel getTop1() {
		return productDao.getTop1();
	}

	@Override
	public List<ProductModel> getTop4() {
		return productDao.getTop4();
	}

	@Override
	public List<ProductModel> getAllProduct(int pageNumber, int rowsOfPage, int userid) {
		return productDao.getAllProduct(pageNumber, rowsOfPage, userid);
	}

	@Override
	public int countAll(int userid) {
		return productDao.countAll(userid);
	}

	@Override
	public ProductModel getProductByID(int productid, int userid) {
		return productDao.getProductByID(productid, userid);
	}

	@Override
	public int getProductID(String name, int userid) {
		return productDao.getProductID(name,userid);
	}
	
}
