package ShopTheThao.DAO;

import java.util.List;

import ShopTheThao.Model.ShipModel;

public interface ShipDAO {
	void insert(ShipModel ship); 
	void edit(ShipModel ship); 
	void delete(ShipModel ship);
	List<ShipModel> getAllShip();
	ShipModel get(int id); 
}
