package ShopTheThao.Service;

import java.util.List;

import ShopTheThao.Model.UserModel;

public interface UserService {
	void insert(UserModel user, int roleId);
	void edit(UserModel user);
	void delete(UserModel user);
	void changePassword(UserModel user, String password);
	UserModel get(int id); // Lấy người dùng theo ID
	UserModel get(String username); // Lấy người dùng theo tên đăng nhập
	List<UserModel> search(String keyword); // Tìm kiếm người dùng
	List<UserModel> getByPaging(int pageNumber, int rowsOfPage); // Lấy toàn bộ người dùng theo trang
	boolean checkExistUsername(String username);
	boolean checkLogin(String username,String password);
	int countAll();
}
