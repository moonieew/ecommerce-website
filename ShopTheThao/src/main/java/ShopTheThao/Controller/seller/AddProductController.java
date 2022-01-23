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

import ShopTheThao.Model.CategoryModel;
import ShopTheThao.Model.ProductModel;
import ShopTheThao.Model.SizeModel;
import ShopTheThao.Model.UserModel;
import ShopTheThao.Service.CategoryService;
import ShopTheThao.Service.ProductService;
import ShopTheThao.Service.SizeService;
import ShopTheThao.Service.Implement.CategoryServiceImpl;
import ShopTheThao.Service.Implement.ProductServiceImpl;
import ShopTheThao.Service.Implement.SizeServiceImpl;


@WebServlet(urlPatterns = {"/seller/add"})
public class AddProductController extends HttpServlet {
	
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
				
				CategoryService categoryService = new CategoryServiceImpl();
				List<CategoryModel> listCategory = new ArrayList<CategoryModel>();
				
				listCategory = categoryService.getAllCategory();
				
				req.setAttribute("listCategory", listCategory);
				req.setAttribute("tagactive", 1);
				req.getRequestDispatcher("/views/seller/add-product.jsp").forward(req, resp);
			}else {
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
		
		ProductService productService = new ProductServiceImpl();		
		HttpSession session = req.getSession();
		UserModel userModel = (UserModel) session.getAttribute("user");
		try {
			
			int sizeS = Integer.parseInt(req.getParameter("sizeS"));
			int sizeM = Integer.parseInt(req.getParameter("sizeM"));
			int sizeL = Integer.parseInt(req.getParameter("sizeL"));
			int sizeXL = Integer.parseInt(req.getParameter("sizeXL"));
			
			String name = req.getParameter("name");
			double price = Double.parseDouble(req.getParameter("price"));
			double salePrice = Double.parseDouble(req.getParameter("saleprice"));		
			int quantity = sizeS + sizeM + sizeL + sizeXL;
			String description = req.getParameter("description");
			int categoryId = Integer.parseInt(req.getParameter("category"));
			String brand = req.getParameter("brand");
			String image = req.getParameter("image");
			
			int userid = userModel.getId();
		
		
			ProductModel productModel = new ProductModel(name, price, salePrice, quantity, description, 
					image, brand, categoryId, userid);
			productService.insert(productModel);
			int productid = productService.getProductID(name, userid);
			CheckQuantity(productid, "S", sizeS);
			CheckQuantity(productid, "M", sizeM);
			CheckQuantity(productid, "L", sizeL);
			CheckQuantity(productid, "XL", sizeXL);
			
		}catch (Exception e) {
			e.printStackTrace();
			//Đẩy thông báo lên nếu bị lỗi
			req.getRequestDispatcher("/views/seller/add-product.jsp").forward(req, resp);
		}
		
		resp.sendRedirect("list");
		
	}
	
	public void CheckQuantity(int productid, String size, int SizeQuantity) {
		SizeService sizeService = new SizeServiceImpl();
		if(SizeQuantity != 0) {
			SizeModel sizeModel = new SizeModel(productid,size,SizeQuantity,1);
			sizeService.insert(sizeModel);
		}else {
			SizeModel sizeModel = new SizeModel(productid,size,SizeQuantity,0);
			sizeService.insert(sizeModel);
		}
	}
	
}
