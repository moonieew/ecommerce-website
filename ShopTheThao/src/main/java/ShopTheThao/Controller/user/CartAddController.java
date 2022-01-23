package ShopTheThao.Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShopTheThao.Model.CartDetailModel;
import ShopTheThao.Model.CartModel;
import ShopTheThao.Model.ProductModel;
import ShopTheThao.Service.CartDetailService;
import ShopTheThao.Service.CartService;
import ShopTheThao.Service.CategoryService;
import ShopTheThao.Service.ProductService;
import ShopTheThao.Service.Implement.CartDetailServiceImpl;
import ShopTheThao.Service.Implement.CartServiceImpl;
import ShopTheThao.Service.Implement.CategoryServiceImpl;
import ShopTheThao.Service.Implement.ProductServiceImpl;


@WebServlet(urlPatterns = {"/cart-add"})
public class CartAddController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6123093175183379188L;
	
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartDetailService cartDetailService = new CartDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String productid = req.getParameter("pid");
		String qtity = req.getParameter("quantity");
		
		String size = req.getParameter("size");
		int pid = Integer.parseInt(productid);
		int quantity = Integer.parseInt(qtity);
		
		ProductModel product = productService.get(pid);
		
		CartModel cartModel = new CartModel();
		
		HttpSession session = req.getSession();
		cartModel = (CartModel)session.getAttribute("cart");
		
		List<CartDetailModel> listCartDetail = cartModel.getListcartdetail();
		int flag = -1;	// = -1 chua ton tai san pham trong gio hang
		int flagSize=-1; // = -1 có tồn tại trong giỏ nhưng không có size này
		for(int i=0; i < listCartDetail.size(); i++) {
			int productIDold = listCartDetail.get(i).getProductid();
			if (productIDold == pid) {
				flag=i;
				if(listCartDetail.get(i).getSize() == size) {
					flagSize=i;	//vị trí chính xác của sản phẩm
				}
				break;
			}
		}
		
		if(flag == -1) {
			double price = (product.getPrice() - (product.getPrice()*product.getSalePrice()/100)) * quantity;
			listCartDetail.add(new CartDetailModel(pid,size,cartModel.getId(),price, quantity, product));
			
			
			int new_cart_quantity = cartModel.getQuantity() + 1;
			double new_cart_grandtotal = cartModel.getGrandTotal() + price;
			
			cartModel.setQuantity(new_cart_quantity);
			cartModel.setGrandTotal(new_cart_grandtotal);
			cartModel.setListcartdetail(listCartDetail);
			
			cartService.edit(cartModel.getId(), new_cart_quantity, new_cart_grandtotal);
			cartDetailService.register(pid, size, cartModel.getId(), price, quantity);
			
			session.setAttribute("cart", cartModel);
			resp.sendRedirect(req.getContextPath()+"/home");
		}
		else {
			if(flagSize == -1) {
				double price = (product.getPrice() - (product.getPrice()*product.getSalePrice()/100)) * quantity;
				listCartDetail.add(new CartDetailModel(pid,size,cartModel.getId(),price, quantity, product));
				
				
				double new_cart_grandtotal = cartModel.getGrandTotal() + price;
				
				cartModel.setGrandTotal(new_cart_grandtotal);
				cartModel.setListcartdetail(listCartDetail);
				
				cartService.edit(cartModel.getId(), cartModel.getQuantity() , new_cart_grandtotal);
				cartDetailService.register(pid, size, cartModel.getId(), price, quantity);
				
				session.setAttribute("cart", cartModel);
				resp.sendRedirect(req.getContextPath()+"/home");
			}else {
				int new_quantity = listCartDetail.get(flagSize).getQuantity() + quantity;
				listCartDetail.get(flagSize).setQuantity(new_quantity);
				
				double new_price = (product.getPrice() - product.getSalePrice()) * new_quantity;
				
				double gia_chenh_lech = new_price - listCartDetail.get(flagSize).getPrice();
				listCartDetail.get(flagSize).setPrice(flagSize);
				
				double new_cart_grandtotal = cartModel.getGrandTotal() + gia_chenh_lech;
				
				
				cartModel.setGrandTotal(new_cart_grandtotal);
				cartModel.setListcartdetail(listCartDetail);
				
				
				cartDetailService.edit(pid,size, cartModel.getId(), new_price, new_quantity);
				
				cartService.edit(cartModel.getId(), cartModel.getQuantity(), new_cart_grandtotal);
				
				session.setAttribute("cart", cartModel);
				resp.sendRedirect(req.getContextPath()+"/home");
			}
			
			
		}
		
		
		
		//req.getRequestDispatcher("/views/web/product.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
