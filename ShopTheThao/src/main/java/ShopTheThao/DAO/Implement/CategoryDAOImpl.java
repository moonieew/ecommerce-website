package ShopTheThao.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ShopTheThao.Connection.MYDB;
import ShopTheThao.DAO.CategoryDAO;
import ShopTheThao.Model.CategoryModel;

public class CategoryDAOImpl implements CategoryDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	@Override
	public void insert(CategoryModel category) {
		String query = "INSERT INTO Category([name],[status]) \r\n" + 
				"VALUES (?,?)";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getName());
			ps.setInt(2, category.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CategoryModel category) {
		String query = "UPDATE Category SET [status] = 0 WHERE id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, category.getId());
			ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryModel> getAllCategory() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String query = "SELECT * FROM Category WHERE [status] = 1";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2),rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CategoryModel get(int id) {
		String query = "SELECT * FROM Category WHERE id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return (new CategoryModel(rs.getInt(1), rs.getString(2),rs.getInt(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
