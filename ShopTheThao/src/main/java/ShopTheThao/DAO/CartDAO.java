package ShopTheThao.DAO;

import ShopTheThao.Model.CartModel;

public interface CartDAO {

	CartModel get(int userId);

	void edit(int cartid, int quantity, double grandtotal);
		
}
