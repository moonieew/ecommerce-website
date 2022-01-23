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
import ShopTheThao.Model.SizeModel;
import ShopTheThao.Service.CategoryService;
import ShopTheThao.Service.ProductService;
import ShopTheThao.Service.SizeService;
import ShopTheThao.Service.Implement.CategoryServiceImpl;
import ShopTheThao.Service.Implement.ProductServiceImpl;
import ShopTheThao.Service.Implement.SizeServiceImpl;



@WebServlet(urlPatterns = { "/productdetail" })
public class ProductDetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3678957517597630468L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String pid = req.getParameter("pid");
		String cid = req.getParameter("cid");
		
		ProductService productService = new ProductServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();
		SizeService sizeService = new SizeServiceImpl();
		int productid = Integer.parseInt(pid);
		List<SizeModel> listSize = sizeService.getSizeByProductID(productid);
		
		try {
			ProductModel ProductByID = productService.get(Integer.parseInt(pid));
			CategoryModel CateByID = categoryService.get(Integer.parseInt(cid));
			req.setAttribute("ProductByID", ProductByID);
			req.setAttribute("CateByID", CateByID);
		} catch (Exception e) {
			// TODO: handle exception
		}

		List<CategoryModel> listCategory = categoryService.getAllCategory();
		System.out.println(listSize);
		req.setAttribute("listSize", listSize);
		req.setAttribute("listCategory", listCategory);
		
		RequestDispatcher rq = req.getRequestDispatcher("/views/user/product-detail.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
