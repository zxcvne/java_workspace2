package product;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	// main 처리를 하는 컨트롤러
	// controller <-> service <-> DAO <-> DB
	// 화면에서 데이터를 전달하면 반드시 컨트롤러가 데이터를 처리
	// 데이터를 처리하는 서비스와 연결
	// List<String> list = new ArrayList<>(); // 인터페이스를 구현체로 연결
	private Scanner scan;
	private boolean flag; // 종료변수로 사용
	private ProductServiceInterface psv;
	
	public ProductController () {
		scan = new Scanner(System.in);
		psv = new ProductService(); // 구현 클래스와 연결
		flag = true; // 실행 상태
		printMenu(); // 메뉴 호출
	}
	
	private void printMenu() {
		// 메뉴 생성
		while(flag) {
			System.out.println("--상품관리프로그램--");
			System.out.println("1.상품등록|2.상품리스트|3.상품상세");
			System.out.println("4.상품수정|5.상품삭제 |6.종료");
			System.out.println("메뉴선택>");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: add(); break;
			case 2: list(); break;
			case 3: detail(); break;
			case 4: modify(); break;
			case 5: remove(); break;
			case 6: flag=false; System.out.println("종료"); break;
			default: System.out.println("잘못된 메뉴"); break;
			}
		}
		
	}
	
	private void remove() {
		// 삭제할 상품번호를 받아서 삭제
		System.out.println("상품번호>");
		int pno = scan.nextInt();

		int isOk = psv.remove(pno);
		
		System.out.println("상품삭제 > " + ((isOk == 1)? "성공":"실패"));
	}

	private void modify() {
		// 수정할 상품 번호를 받아서 수정 내용을 객체로 생성
		System.out.println("상품번호>");
		int pno = scan.nextInt();
		
		System.out.println("상품명>");
		scan.nextLine();
		String pname = scan.nextLine();
		
		System.out.println("가격>");
		int price = scan.nextInt();
		
		System.out.println("상세정보>");
		scan.nextLine(); // enter 처리용
		String madeby = scan.nextLine();
		
		Product p = new Product(pname, price, madeby, pno);
		
		int isOk = psv.modify(p);
		System.out.println("상품수정 > " + ((isOk == 1)? "성공":"실패"));
	}

	private void detail() {
		// 상품 상세 정보 보기
		System.out.println("상품번호>");
		int pno = scan.nextInt();
		Product p = psv.getDetail(pno);
		if(p != null) {
			p.print();
		}else {
			System.out.println("없는 상품입니다.");
		}
	}

	private void list() {
		// 전체 상품 리스트 보기
		List<Product> list = psv.getList();
		// 출력
		for(Product p : list) {
			System.out.println(p);
		}
	}
	
	
	private void add() {
		// 등록할 product 객체를 생성
		System.out.println("상품명>");
		scan.nextLine();
		String pname = scan.nextLine();
		
		System.out.println("가격>");
		int price = scan.nextInt();
		
		System.out.println("상세정보>");
		scan.nextLine(); // enter 처리용
		String madeby = scan.nextLine();
		
		Product p = new Product(pname, price, madeby);
		
		// service에게 객체를 등록하는 요청 메서드 작성
		// insert, update, delete : 리턴 없음 DB 자체가 변경됨.
		// 잘 등록되면 1(1개의 행이 잘 처리되었다.) 아니면 0
		// error (구문오류)
		int isOk = psv.insert(p);
		
		System.out.println("상품등록 > " + ((isOk == 1)? "성공":"실패"));
	}
}
