package product;

import java.util.List;

public interface ProductServiceInterface {
	// service interface

	int insert(Product p);

	List<Product> getList();

	Product getDetail(int pno);

	int modify(Product p);

	int remove(int pno);

	

}
