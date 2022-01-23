package ShopTheThao.Controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShopTheThao.Model.UserModel;


@WebServlet(urlPatterns = { "/seller/thongke" })
public class ThongKeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8888819753193939013L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			if (userModel != null && userModel.getRoleId() == 2) {
				
				
				req.setAttribute("tagactive", 4);
				req.getRequestDispatcher("/views/seller/thongke.jsp").forward(req, resp);
				
			} else {
				resp.sendRedirect(req.getContextPath() + "/account/login");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/account/login");
		}
	}
}
