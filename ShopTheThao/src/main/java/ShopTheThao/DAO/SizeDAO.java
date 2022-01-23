package ShopTheThao.DAO;

import java.util.List;

import ShopTheThao.Model.SizeModel;

public interface SizeDAO {

	void insert(SizeModel size);

	List<SizeModel> getSizeByProductID(int productid);

	void edit(SizeModel size);

}
