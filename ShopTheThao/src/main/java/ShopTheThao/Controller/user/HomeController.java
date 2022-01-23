package ShopTheThao.Controller.user;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShopTheThao.Model.CategoryModel;
import ShopTheThao.Model.ProductModel;
import ShopTheThao.Service.CategoryService;
import ShopTheThao.Service.ProductService;
import ShopTheThao.Service.Implement.CategoryServiceImpl;
import ShopTheThao.Service.Implement.ProductServiceImpl;




@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 616311058943066092L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		ProductService productService = new ProductServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();
		
		List<ProductModel> top4product = productService.getTop4();
		ProductModel topProduct = productService.getTop1();
		List<CategoryModel> listCategory = categoryService.getAllCategory();
		
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("list4product", top4product);
		req.setAttribute("topProduct", topProduct);

		RequestDispatcher rq = req.getRequestDispatcher("/views/user/home.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
