package ShopTheThao.Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShopTheThao.Model.UserModel;
import ShopTheThao.Service.UserService;
import ShopTheThao.Service.Implement.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/useradd" })
public class UserAddController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1054398575967331169L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			System.out.println(userModel.toString());
			if (userModel != null && userModel.getRoleId() == 1) {
				req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/account/login");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/account/login");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String gender = req.getParameter("gender");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String roleId = req.getParameter("roleId");
		UserService uService = new UserServiceImpl();
		if (!uService.checkExistUsername(username)) {
			UserModel uuUserModel = new UserModel(username, password, fname, lname, Integer.parseInt(gender), phone, email, address, Integer.parseInt(roleId));
			uService.insert(uuUserModel, Integer.parseInt(roleId));
			String mess = "Tạo tài khoản thành công";
			req.setAttribute("mess", mess);
			req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
		} else {
			String mess = "Tên tài khoản đã tồn tại";
			req.setAttribute("mess", mess);
			req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
		}
	}
}
