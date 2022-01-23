package ShopTheThao.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ShopTheThao.Connection.MYDB;
import ShopTheThao.DAO.SizeDAO;
import ShopTheThao.Model.SizeModel;

public class SizeDAOImpl implements SizeDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	
	@Override
	public void insert(SizeModel size) {
		String query = "{call dbo.SP_RegisterSize(?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, size.getproductId());
			ps.setString(2, size.getSize());
			ps.setInt(3, size.getQuantity());
			ps.execute();
		} catch (Exception e) {
			
		}
	}

	@Override
	public List<SizeModel> getSizeByProductID(int productid) {
		List<SizeModel> listSize = new ArrayList<SizeModel>();
		String query = "SELECT * FROM Size WHERE productid = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productid);
			rs = ps.executeQuery();
			while(rs.next()) {
				listSize.add(new SizeModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			
		}
		return listSize;
	}
	
	@Override
	public void edit(SizeModel size) {	
		String query = "{call dbo.SP_EditSize(?,?,?,?)}";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, size.getproductId());
			ps.setString(2, size.getSize());
			ps.setInt(3, size.getQuantity());
			ps.setInt(4, size.getStatus());
			ps.execute();
		} catch (Exception e) {
			
		}
	}
	
	
	public static void main(String[] args) {
		/*SizeDAOImpl sdi = new SizeDAOImpl();
		SizeModel size = new SizeModel(15,"XL",1,1);
		sdi.edit(size);*/
		
	}
	
}
