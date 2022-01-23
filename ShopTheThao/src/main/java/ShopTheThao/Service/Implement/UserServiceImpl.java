package ShopTheThao.Service.Implement;

import java.util.List;

import ShopTheThao.DAO.UserDAO;
import ShopTheThao.DAO.Implement.UserDAOImpl;
import ShopTheThao.Model.UserModel;
import ShopTheThao.Service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO userdao = new UserDAOImpl();
	@Override
	public void insert(UserModel user, int roleId) {
		userdao.insert(user, roleId);
	}

	@Override
	public void edit(UserModel user) {
		userdao.edit(user);
	}

	@Override
	public void delete(UserModel user) {
		userdao.delete(user);
	}

	@Override
	public void changePassword(UserModel user, String password) {
		userdao.changePassword(user, password);
	}

	@Override
	public UserModel get(int id) {
		return userdao.get(id);
	}

	@Override
	public UserModel get(String username) {
		return userdao.get(username);
	}

	@Override
	public List<UserModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getByPaging(int pageNumber, int rowsOfPage) {
		return userdao.getByPaging(pageNumber, rowsOfPage);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userdao.checkExistUsername(username);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		return userdao.checkLogin(username, password);
	}

	@Override
	public int countAll() {
		return userdao.countAll();
	}

}
