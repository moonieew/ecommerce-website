package ShopTheThao.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ShopTheThao.Connection.MYDB;
import ShopTheThao.DAO.CartDetailDAO;
import ShopTheThao.DAO.ProductDAO;
import ShopTheThao.Model.CartDetailModel;
import ShopTheThao.Model.ProductModel;



public class CartDetailDAOImpl implements CartDetailDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	ResultSet rs = null;	
	
	
	@Override
	public List<CartDetailModel> get(int cartid) {
		List<CartDetailModel> cartdetailModel = new ArrayList<CartDetailModel>();
		ProductModel productModel = new ProductModel();
		ProductDAO productDao = new ProductDAOImpl();
		String query = "SELECT * FROM CartDetail WHERE cartid = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartid);
			rs = ps.executeQuery();
			while(rs.next()) {
				cartdetailModel.add(new CartDetailModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5)));
				productModel = productDao.get(rs.getInt(1));
				cartdetailModel.get(cartdetailModel.size()-1).setProductmodel(productModel);
			}
		} catch (Exception e) {
			
		}
		
		return cartdetailModel;
	}
	
	public static void main(String[] args) {
		List<CartDetailModel> cdm = new ArrayList<CartDetailModel>();
		CartDetailDAO cdd = new CartDetailDAOImpl();
		cdd.edit(1, "S", 1, 225000, 2);
	}

	@Override
	public void edit(int productid,String size, int cartid, double price, int quantity) {
		String query = "{call dbo.SP_EditCartDetail (?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productid);
			ps.setString(2, size);
			ps.setInt(3, cartid);
			ps.setDouble(4, price);
			ps.setInt(5, quantity);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
	}

	@Override
	public void register(int producid,String size, int cartid, double price, int quantity) {
		String query = "{call dbo.SP_RegisterCartDetail(?,?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, producid);
			ps.setString(2, size);
			ps.setInt(3, cartid);
			ps.setDouble(4, price);
			ps.setInt(5, quantity);
			rs = ps.executeQuery();
			
		} catch (Exception e) {

		}
		
	}

	@Override
	public void delete(int productid, int cartid) {
		String query = "DELETE  FROM [CartDetail] WHERE productid = @productid AND cartid = @cartid";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productid);
			ps.setInt(2, cartid);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
		
	}

	@Override
	public void deleteAll(int cartid) {
		String query = "{call dbo.SP_DeleteAllCartDetail (?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartid);
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {

		}
		
	}

}
