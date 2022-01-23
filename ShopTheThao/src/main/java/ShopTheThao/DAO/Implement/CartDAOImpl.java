package ShopTheThao.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ShopTheThao.Connection.MYDB;
import ShopTheThao.DAO.CartDAO;
import ShopTheThao.Model.CartModel;



public class CartDAOImpl implements CartDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	
	@Override
	public CartModel get(int userid) {
		CartModel cartmodel = new CartModel();
		String query = "SELECT * FROM Carts WHERE userid = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				cartmodel = new CartModel(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4));
			}
		} catch (Exception e) {

		}
		return cartmodel;
	}
	
	public static void main(String[] args) {
		CartDAO cd=new CartDAOImpl();
		CartModel cm = new CartModel();
	}

	@Override
	public void edit(int cartid, int quantity,  double grandtotal) {
		String query = "UPDATE Carts\r\n" + 
				"SET quantity = ?, grandtotal = ?\r\n" + 
				"WHERE id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(3, cartid);
			ps.setInt(1, quantity);
			ps.setDouble(2, grandtotal);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
		
	}

}
