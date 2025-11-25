package product;

import java.util.List;

public interface ProductDAOInterface {
	//	DAO Interface
	//  DAO대한 목록화

	

	int insert(Product p);

	List<Product> getList();

	Product getDetail(int pno);

	int modify(Product p);

	int remove(int pno);


	
}
