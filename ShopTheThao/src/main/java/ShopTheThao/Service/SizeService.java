package ShopTheThao.Service;

import java.util.List;

import ShopTheThao.Model.SizeModel;

public interface SizeService {
	
	void insert(SizeModel size);
	
	List<SizeModel> getSizeByProductID(int productid);

	void edit(SizeModel size);
}
