package ShopTheThao.Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShopTheThao.Model.CategoryModel;
import ShopTheThao.Service.CategoryService;
import ShopTheThao.Service.Implement.CategoryServiceImpl;

@WebServlet(urlPatterns="/admin/deletecategory")
public class DeleteCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6330562889447968351L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryService categorySer = new CategoryServiceImpl();
		CategoryModel categoryObj = categorySer.get(Integer.parseInt(id));
		try {
			categorySer.delete(categoryObj);
			System.out.println("Xoá danh mục thành công");
			resp.sendRedirect(req.getContextPath()+"/admin/category");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
