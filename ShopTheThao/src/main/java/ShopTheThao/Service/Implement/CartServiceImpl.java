package ShopTheThao.Service.Implement;

import ShopTheThao.DAO.CartDAO;
import ShopTheThao.DAO.Implement.CartDAOImpl;
import ShopTheThao.Model.CartModel;
import ShopTheThao.Service.CartService;

public class CartServiceImpl implements CartService{
	CartDAO cartDAO = new CartDAOImpl();

	@Override
	public CartModel get(int userId) {
		return cartDAO.get(userId);
	}

	@Override
	public void edit(int cartid, int quantity, double grandtotal) {
		cartDAO.edit(cartid, quantity, grandtotal);
	}
	

}
