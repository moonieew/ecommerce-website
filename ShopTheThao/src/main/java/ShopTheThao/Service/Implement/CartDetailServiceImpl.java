package ShopTheThao.Service.Implement;

import java.util.List;

import ShopTheThao.DAO.CartDetailDAO;
import ShopTheThao.DAO.Implement.CartDetailDAOImpl;
import ShopTheThao.Model.CartDetailModel;
import ShopTheThao.Service.CartDetailService;



public class CartDetailServiceImpl implements CartDetailService{
	CartDetailDAO cartdetailDao = new CartDetailDAOImpl();
	
	@Override
	public List<CartDetailModel> get(int cartid) {
		return cartdetailDao.get(cartid);
	}

	@Override
	public void edit(int productid,String size, int cartid, double price, int quantity) {
		cartdetailDao.edit(productid,size,cartid,price,quantity);
	}

	@Override
	public void register(int producid,String size, int cartid, double price, int quantity) {
		cartdetailDao.register(producid,size,cartid,price,quantity);
		
	}

	@Override
	public void delete(int productid, int cartid) {
		cartdetailDao.delete(productid, cartid);
		
	}

	@Override
	public void deleteAll(int cartid) {
		cartdetailDao.deleteAll(cartid);
		
	}

}
