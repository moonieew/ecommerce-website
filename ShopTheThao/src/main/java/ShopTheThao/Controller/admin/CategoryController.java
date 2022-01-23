package ShopTheThao.Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShopTheThao.Model.CategoryModel;
import ShopTheThao.Model.UserModel;
import ShopTheThao.Service.CategoryService;
import ShopTheThao.Service.Implement.CategoryServiceImpl;

@WebServlet(urlPatterns="/admin/category")
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7876127703835959293L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			UserModel userModel = (UserModel) session.getAttribute("user");
			if (userModel != null && userModel.getRoleId() == 1) {
				CategoryService categorySer = new CategoryServiceImpl();
				// Đưa list Category lên
				List<CategoryModel> categoryList = categorySer.getAllCategory();
				req.setAttribute("categoryList", categoryList);
				req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
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
		CategoryService categorySer = new CategoryServiceImpl();
		String name = req.getParameter("name");
		
		try {
			CategoryModel CategoryObj = new CategoryModel(name,1);
			categorySer.insert(CategoryObj);
			String mess = "Tạo danh mục thành công";
			List<CategoryModel> categoryList = categorySer.getAllCategory();
			req.setAttribute("mess", mess);
			req.setAttribute("categoryList", categoryList);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
