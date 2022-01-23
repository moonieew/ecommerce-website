package ShopTheThao.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ShopTheThao.Connection.MYDB;
import ShopTheThao.DAO.UserDAO;
import ShopTheThao.Model.UserModel;

public class UserDAOImpl implements UserDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement CSS = null;
	ResultSet rs = null;
	@Override
	public void insert(UserModel user, int roleId) {
		String query = "INSERT INTO [User] \r\n" + 
				"(username, password, fname, lname, gender, phone, email, address, roleid) \r\n" + 
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFname());
			ps.setString(4, user.getLname());
			ps.setInt(5, user.getGender());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPassword());
			ps.setInt(9, roleId);
			ps.executeUpdate();
			System.out.println("Thêm tài khoản thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(UserModel user) {
		String query = "UPDATE [User] SET fname=?, lname=?, phone=?, email = ?, address = ?\r\n" + 
				"WHERE id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setInt(6, user.getId());
			ps.executeUpdate();
			System.out.println("Chỉnh sửa thông tin thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(UserModel user) {
		String query = "DELETE FROM [User]\r\n" + 
				"	WHERE id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, user.getId());
			ps.executeUpdate();
			System.out.println("Xoá người dùng thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changePassword(UserModel user, String password) {
		String query = "UPDATE [User] SET password = ? WHERE username = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, user.getUsername());
			ps.executeUpdate();
			System.out.println("Thay đổi mật khẩu thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel get(int id) {
		String query = "select * from [User] where id = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public UserModel get(String username) {
		String query = "select * from [User] where username = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public List<UserModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getByPaging(int pageNumber, int rowsOfPage) {
		List<UserModel> list = new ArrayList<UserModel>();
		String query = "SELECT * FROM [User]\r\n" + 
				"	ORDER BY id \r\n" + 
				"	OFFSET (?-1)*? ROWS\r\n" + 
				"	FETCH NEXT ? ROWS ONLY";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, pageNumber);
			ps.setInt(2, rowsOfPage);
			ps.setInt(3, rowsOfPage);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public boolean checkExistUsername(String username) {
		String query = "select * from [User] where username = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public boolean checkLogin(String username, String password) {
		String query = "SELECT * FROM [User] WHERE username= ? AND password = ?";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public int countAll() {
		String query = "SELECT COUNT(*)\r\n" + 
				"FROM [User]";
		try {
			conn = new MYDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		List<UserModel> list = userDAO.getByPaging(1, 5);
		for (UserModel userModel : list) {
			System.out.println(userModel.getUsername());
		}
		System.out.println(list);
	}

}
