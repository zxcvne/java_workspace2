package product;

public class ProductService implements ProductServiceInterface {
	// Controller <-> service <-> DAO
	// controller에서 처리된 객체를 받아 각 DAO로 전달 (객체의 해체 / 조립)
	
	// 기능에 대한 목록화
	// 차후 유지보수를 위해
	private ProductDAOInterface pdao;
	
	public ProductService() {
		pdao = new ProductDAO();
	}
	
	// controller에서 오는 처리를 맡아서 함.
}
