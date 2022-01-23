package ShopTheThao.Controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShopTheThao.Model.UserModel;
import ShopTheThao.Service.UserService;
import ShopTheThao.Service.Implement.UserServiceImpl;

@WebServlet(urlPatterns = "/account/register")
public class RegisterController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7532855129904949346L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/views/account/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String roleId = req.getParameter("roleId");
		UserService uService = new UserServiceImpl();
		if(!uService.checkExistUsername(username)) {
			if(password.equals(repassword)) {
				UserModel uuUserModel = new UserModel(username, password, fname, lname, Integer.parseInt(gender), phone, email, address, Integer.parseInt(roleId));		
				System.out.print(uuUserModel.toString());
				uService.insert(uuUserModel, Integer.parseInt(roleId));
				
				resp.sendRedirect(req.getContextPath()+"/account/login");
			}
			else {
				System.out.println("Mật khẩu nhập lại không đúng");
			}

		}
		else {
			System.out.println("Tên đăng nhập đã tồn tại");
		}
	}
}
