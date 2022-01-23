package ShopTheThao.Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ShopTheThao.Model.ShipModel;
import ShopTheThao.Model.UserModel;

import ShopTheThao.Service.ShipService;

import ShopTheThao.Service.Implement.ShipServiceImpl;

@WebServlet(urlPatterns="/admin/ship")
public class ShipController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4195857684642850435L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			if (userModel != null && userModel.getRoleId() == 1) {
				ShipService shipSer = new ShipServiceImpl();
				// Đưa list Category lên
				List<ShipModel> shipList = shipSer.getAllShip();
				req.setAttribute("shipList", shipList);
				req.getRequestDispatcher("/views/admin/ship.jsp").forward(req, resp);
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
		ShipService shipSer = new ShipServiceImpl();
		String cachship = req.getParameter("cachship");
		String price = req.getParameter("price");
		
		try {
			ShipModel ShipObj = new ShipModel(cachship, Double.parseDouble(price));
			shipSer.insert(ShipObj);
			String mess = "Tạo loại ship thành công";
			List<ShipModel> shipList  = shipSer.getAllShip();
			req.setAttribute("mess", mess);
			req.setAttribute("shipList", shipList);
			req.getRequestDispatcher("/views/admin/ship.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
