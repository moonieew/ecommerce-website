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


@WebServlet(urlPatterns = {"/seller/detail"})
public class ProductDetailController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7461168081520992837L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel userModel = (UserModel) session.getAttribute("user");
		int userid = userModel.getId();
		
		ProductService productService = new ProductServiceImpl();	
		SizeService sizeService = new SizeServiceImpl();
		
		CategoryService categoryService = new CategoryServiceImpl();
		List<CategoryModel> listCategory = new ArrayList<CategoryModel>();
		
		listCategory = categoryService.getAllCategory();
		
		
		
		int pid = Integer.parseInt(req.getParameter("pid"));
		ProductModel product = productService.getProductByID(pid, userid);
		
		List<SizeModel> listSize = sizeService.getSizeByProductID(pid);
		int sizeS = 0, sizeM = 0, sizeL = 0, sizeXL = 0;
		for (int i = 0; i < listSize.size(); i++) {
			switch(listSize.get(i).getSize()) {
				case "S":
					sizeS = listSize.get(i).getQuantity();
					break;
				case "M":
					sizeM = listSize.get(i).getQuantity();
					break;
				case "L":
					sizeL = listSize.get(i).getQuantity();
					break;
				case "XL":
					sizeXL = listSize.get(i).getQuantity();
					break;
			}
		}
		
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("product", product);
		req.setAttribute("sizeS", sizeS);
		req.setAttribute("sizeM", sizeM);
		req.setAttribute("sizeL", sizeL);
		req.setAttribute("sizeXL", sizeXL);
		req.setAttribute("tagactive", 0);
		
		req.getRequestDispatcher("/views/seller/detail-product.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		UserModel userModel = (UserModel) session.getAttribute("user");
		int userid = userModel.getId();
		
		ProductService productService = new ProductServiceImpl();
		
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
			int productid = Integer.parseInt(req.getParameter("productid"));
			String brand = req.getParameter("brand");
			String image = req.getParameter("image");
			
		
		
			ProductModel productModel = new ProductModel(productid, name, price, salePrice, quantity, description, 
					image, brand, categoryId, userid, 1);
			productService.edit(productModel);
			
			CheckQuantity(productid, "S", sizeS);
			CheckQuantity(productid, "M", sizeM);
			CheckQuantity(productid, "L", sizeL);
			CheckQuantity(productid, "XL", sizeXL);
			
		}catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/views/seller/add-product.jsp").forward(req, resp);
		}
		
		resp.sendRedirect("list");
	}
	
	public void CheckQuantity(int productid, String size, int SizeQuantity) {
		SizeService sizeService = new SizeServiceImpl();
		if(SizeQuantity == 0) {
			SizeModel sizeModel = new SizeModel(productid,size,SizeQuantity,0);
			sizeService.edit(sizeModel);
		}else {
			SizeModel sizeModel = new SizeModel(productid,size,SizeQuantity,1);
			sizeService.edit(sizeModel);
		}
	}
}
