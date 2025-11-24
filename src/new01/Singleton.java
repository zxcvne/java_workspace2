package new01;

class Single {
	// 단 1개만 존재해야 하는 객체를 생성
	private static Single instance;
	
	// public Single( ) {} // 기본 제공되는 생성자
	// 생성자를 통해 객체를 생성하는 것을 막기 위해 생성자를 private으로 생성
	private Single() {}
	
	// getter를 통해서만 인스턴스를 얻을 수 있음.
	 public static Single getInstance() {
		 // 만약 instance가 없으면 생성해서 리턴
		 // 있으면 기존 instance를 리턴
		 if(instance == null) {
			 instance = new Single();
		 }
		 return instance;
	 }
}

public class Singleton {
	public static void main(String[] args) {
		/* 싱글턴(Singleton) : 디자인 패턴 중 생성 패턴의 일종
		 * 단 1개의 객체만 존재하게 하고자 할 때 사용
		 * => 객체 1개로 공유
		 * */		
		
		// 객체 생성
		// Single s = new Single(); // 생성불가
		
		Single s = Single.getInstance();
		Single s2 = Single.getInstance();
		
		System.out.println(s); // 같은 주소를 공유하고 있음. 
		System.out.println(s2);
		
	}
}
