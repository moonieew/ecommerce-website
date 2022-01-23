package ShopTheThao.Controller.user;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShopTheThao.Model.CartDetailModel;
import ShopTheThao.Model.CartModel;
import ShopTheThao.Model.UserModel;
import ShopTheThao.Service.CartDetailService;
import ShopTheThao.Service.CartService;
import ShopTheThao.Service.UserService;
import ShopTheThao.Service.Implement.CartDetailServiceImpl;
import ShopTheThao.Service.Implement.CartServiceImpl;
import ShopTheThao.Service.Implement.UserServiceImpl;

@WebServlet(urlPatterns = "/account/login")
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3718423354186870926L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/views/account/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService userService = new UserServiceImpl();
		CartService cartService = new CartServiceImpl();
		CartDetailService cartdetailService = new CartDetailServiceImpl();
		//Check login
//		System.out.println("user:" + username);
//		System.out.println("pass: " + password);
		if(userService.checkLogin(username, password)) {
			UserModel userModel = userService.get(username);
			if(userModel.getRoleId()==3) {
				CartModel cartModel = cartService.get(userModel.getId());
				List<CartDetailModel> cartdetailModel = cartdetailService.get(cartModel.getId());
				cartModel.setListcartdetail(cartdetailModel);
				session.setAttribute("cart", cartModel);
			}
			
			
			
			session.setAttribute("user", userModel);
			
			// Phân quyền
			req.setAttribute("mess", "Đăng nhập thành công");
			if(userModel.getRoleId()==1) {
				resp.sendRedirect(req.getContextPath()+"/admin/userlist");
			}else if(userModel.getRoleId()==2) {
				resp.sendRedirect(req.getContextPath()+"/seller/list");
			}		
			else {
				resp.sendRedirect(req.getContextPath()+"/home");
			}
		}else {
			req.setAttribute("mess", "Tên đăng nhập hoặc mật khẩu không đúng");
			req.getRequestDispatcher("/views/account/login.jsp").forward(req, resp);
		}
	}
}
