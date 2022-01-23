package ShopTheThao.Service.Implement;

import java.util.List;

import ShopTheThao.DAO.SizeDAO;
import ShopTheThao.DAO.Implement.SizeDAOImpl;
import ShopTheThao.Model.SizeModel;
import ShopTheThao.Service.SizeService;

public class SizeServiceImpl implements SizeService{
	SizeDAO sizedao = new SizeDAOImpl();
	
	@Override
	public void insert(SizeModel size) {
		sizedao.insert(size);
	}

	@Override
	public List<SizeModel> getSizeByProductID(int productid) {
		return sizedao.getSizeByProductID(productid);
	}
	
	@Override
	public void edit(SizeModel size) {
		sizedao.edit(size);
	}
	
}
