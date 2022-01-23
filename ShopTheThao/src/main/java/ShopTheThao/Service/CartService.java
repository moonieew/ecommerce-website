package ShopTheThao.Service;

import ShopTheThao.Model.CartModel;

public interface CartService {
	
	CartModel get(int userId);
	
	void edit(int cartid,int quantity, double grandtotal);
}
