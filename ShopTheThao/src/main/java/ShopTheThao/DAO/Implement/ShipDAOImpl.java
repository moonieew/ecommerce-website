package ShopTheThao.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ShopTheThao.Connection.MYDB;
import ShopTheThao.DAO.ShipDAO;
import ShopTheThao.Model.ShipModel;
import ShopTheThao.Service.ShipService;
import ShopTheThao.Service.Implement.ShipServiceImpl;

public class ShipDAOImpl implements ShipDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	@Override
	public void insert(ShipModel ship) {
		String query = "INSERT INTO Ship([cachship],[price]) \r\n" + 
				"VALUES (?,?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, ship.getCachShip());
			ps.setDouble(2, ship.getPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(ShipModel ship) {
		String query = "UPDATE Ship SET [cachship] = ?, price = ? WHERE id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, ship.getCachShip());
			ps.setDouble(2, ship.getPrice());
			ps.setInt(3, ship.getId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(ShipModel ship) {

	}

	@Override
	public List<ShipModel> getAllShip() {
		List<ShipModel> list = new ArrayList<ShipModel>();
		String query = "SELECT * FROM Ship";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ShipModel(rs.getInt(1), rs.getString(2),rs.getDouble(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ShipModel get(int id) {
		String query = "SELECT * FROM Ship WHERE id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return (new ShipModel(rs.getInt(1), rs.getString(2),rs.getDouble(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		ShipModel shipObj  = new ShipModel(3, "K", 50000);
		ShipService shipSer = new ShipServiceImpl();
		shipSer.edit(shipObj);
		System.out.println(".........");
	}
}
