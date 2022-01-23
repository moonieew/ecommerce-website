package ShopTheThao.DAO;

import java.util.List;

import ShopTheThao.Model.CartDetailModel;



public interface CartDetailDAO {

	List<CartDetailModel> get(int cartid);

	void edit(int productid,String size, int cartid, double price, int quantity);

	void register(int producid,String size, int cartid, double price, int quantity);

	void delete(int productid, int cartid);
	
	void deleteAll(int cartid);

}
