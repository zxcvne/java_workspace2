package product;

import java.util.List;

public class ProductService implements ProductServiceInterface {
	// Controller <-> service <-> DAO
	// controller에서 처리된 객체를 받아 각 DAO로 전달 (객체의 해체 / 조립)
	
	// 기능에 대한 목록화
	// 차후 유지보수를 위해
	private ProductDAOInterface pdao;
	
	public ProductService() {
		pdao = new ProductDAO(); // 구현체
	}

	// controller에서 오는 처리를 맡아서 함.
	@Override
	public int insert(Product p) {
		// DAO => p 전달
		// 만약 p 객체가 테이블을 나누어 저장해야 되는 상황이라면
		// 여기서 분리 => 각자 DAO 에게 요청
		// int isOk = fileDao.insert(file)
		// isOk *= pdao.insert(p)
		// return isOk;
		return pdao.insert(p);
	}

	@Override
	public List<Product> getList() {
		// DAO에게 list 달라고 요청
		return pdao.getList();
	}

	@Override
	public Product getDetail(int pno) {	
		return pdao.getDetail(pno);
	}

	@Override
	public int modify(Product p) {
		// TODO Auto-generated method stub
		return pdao.modify(p);
	}

	@Override
	public int remove(int pno) {
		// TODO Auto-generated method stub
		return pdao.remove(pno);
	}

	
	
}
