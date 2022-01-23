package ShopTheThao.Service.Implement;

import java.util.List;

import ShopTheThao.DAO.ShipDAO;
import ShopTheThao.DAO.Implement.ShipDAOImpl;
import ShopTheThao.Model.ShipModel;
import ShopTheThao.Service.ShipService;

public class ShipServiceImpl implements ShipService {
	ShipDAO shipDAO = new ShipDAOImpl();
	@Override
	public void insert(ShipModel ship) {
		shipDAO.insert(ship);
		
	}

	@Override
	public void edit(ShipModel ship) {
		shipDAO.edit(ship);
		
	}

	@Override
	public void delete(ShipModel ship) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShipModel> getAllShip() {
		return shipDAO.getAllShip();
	}

	@Override
	public ShipModel get(int id) {
		return shipDAO.get(id);
	}
	
}
