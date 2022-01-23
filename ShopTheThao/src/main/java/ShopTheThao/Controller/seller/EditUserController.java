package ShopTheThao.Controller.seller;

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

@WebServlet(urlPatterns = { "/seller/information" })
public class EditUserController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7513201882447773918L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			if (userModel != null && userModel.getRoleId() == 2) {
				
				
				req.setAttribute("tagactive", 3);
				req.getRequestDispatcher("/views/seller/edit-user.jsp").forward(req, resp);
				
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
		HttpSession session = req.getSession();
		UserModel userModel = (UserModel) session.getAttribute("user");
		int userid = userModel.getId();
		try {
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String gender = req.getParameter("gender");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			
			UserModel user = new UserModel(userid, userModel.getUsername(), userModel.getPassword(), fname, lname, 
					Integer.parseInt(gender), phone, email, address, userModel.getRoleId());
			
			UserService userService = new UserServiceImpl();
			userService.edit(user);
			String mess = "Chỉnh sửa tài khoản thành công";
			req.setAttribute("mess", mess);
			req.setAttribute("user", user);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			String mess = "Chỉnh sửa tài khoản thất bại";
			req.setAttribute("mess", mess);
		}
		
		req.getRequestDispatcher("/views/seller/edit-user.jsp").forward(req, resp);
		
	}
}
