package ShopTheThao.Controller.admin;

import java.io.IOException;

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

@WebServlet(urlPatterns="/admin/editship")
public class EditShipController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2767571952240092741L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			if (userModel != null && userModel.getRoleId() == 1) {
				String id = req.getParameter("id");
				String cachShip = req.getParameter("cachship");
				String price = req.getParameter("price");
				System.out.println(id + cachShip + price);
				if(id!= null && cachShip != null && price != null) {
					req.setAttribute("shipValue", cachShip);
					req.setAttribute("priceValue", Double.parseDouble(price));
					req.setAttribute("idValue", Integer.parseInt(id));
				}
				req.getRequestDispatcher("/views/admin/ship-edit.jsp").forward(req, resp);
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
		
		String id = req.getParameter("id");
		String cachship = req.getParameter("cachship");
		String price = req.getParameter("price");
		try {
			ShipModel shipObj  = new ShipModel(Integer.parseInt(id), cachship, Double.parseDouble(price));
			shipSer.edit(shipObj);
			System.out.println("Sửa thành công");
			resp.sendRedirect(req.getContextPath()+"/admin/ship");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
