package product;

import java.util.Scanner;

public class ProductController {
	// main 처리를 하는 컨트롤러
	// controller <-> service <-> DAO <-> DB
	
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
			System.out.println("4.상품수정|5.상품삭제|6.종료");
			System.out.println("메뉴선택>");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: flag=false; System.out.println("종료"); break;
			default: System.out.println("잘못된 메뉴"); break;
			}
		}
		
	}
}
