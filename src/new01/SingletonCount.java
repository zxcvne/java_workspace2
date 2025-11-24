package new01;

// Counter 객체를 생성 (싱글턴)
// int count -> 멤버변수 추가
// countMethod() // 호출하면 1씩 증가하는 메서드
class Counter{
	private static Counter instance;
	private int count;
	
	private Counter() {
		count = 0;
	}
	
	 public static Counter getInstance() {
		 if(instance == null) {
			 instance = new Counter();
		 }
		 return instance;
	 }
	 
	 public int countMethod() {
		 count++;
		 return count;
	 }
}

public class SingletonCount {
	public static void main(String[] args) {
		// Counter 생성 => countMethod() 호출
		// Counter 생성 => countMethod() 호출
		Counter c1 = Counter.getInstance();
		Counter c2 = Counter.getInstance();
		
		System.out.println(c1.countMethod());
		System.out.println(c2.countMethod());
		System.out.println(c1.countMethod());
		System.out.println(c2.countMethod());
			
	}

}
