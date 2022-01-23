package ShopTheThao.Controller.seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShopTheThao.Model.ProductModel;
import ShopTheThao.Model.UserModel;
import ShopTheThao.Service.ProductService;
import ShopTheThao.Service.Implement.ProductServiceImpl;

@WebServlet(urlPatterns = {"/seller/list"})
public class ListProductController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2017719254253239385L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			if (userModel != null && userModel.getRoleId() == 2) {
				ProductService productService = new ProductServiceImpl();	
				List<ProductModel> listAllProduct = new ArrayList<ProductModel>();
				
				int userid = userModel.getId();
				
				String indexPage = req.getParameter("index");
				if (indexPage == null) {
					indexPage = "1";
				}
				int index = Integer.parseInt(indexPage);
				
				
				int countProduct = productService.countAll(userid);
				int endP = countProduct / 4;
				if (countProduct % 4 != 0) {
					endP++;
				}
				
				
				listAllProduct = productService.getAllProduct(index, 4 ,userid);
				
				
				req.setAttribute("listAllProduct", listAllProduct);
				req.setAttribute("tagactive", 2);
				req.setAttribute("endP", endP);
				req.setAttribute("index", index);
				
				req.getRequestDispatcher("/views/seller/list-product.jsp").forward(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath() + "/account/login");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/account/login");
		}
	}
}
