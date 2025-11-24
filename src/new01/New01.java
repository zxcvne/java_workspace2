package new01;

public class New01 {

	public static void main(String[] args) {
		// 홍길동 주민등록번호 : 881122-1234567
		// 출력 형태
		// 생년월일 : 881122
		// 성별 : 남
		String pin = "881122-1234567";
		String birth = pin.substring(0,pin.indexOf("-"));
//		String userNum = pin.substring(pin.indexOf("-")+1);
//		String gNum = userNum.substring(0,1);
		char ch = pin.charAt(pin.indexOf("-")+1);
		String gender = "";
//		if(gNum.equals("1") || gNum.equals("3")) {
//			gender = "남자";
//		}else {
//			gender = "여자";
//		}
		if(ch=='1'|| ch=='3') {
			gender = "남자";
		}else {
			gender = "여자";
		}
		
		System.out.println("생년월일 : " + birth);
		System.out.println("성별 : " + gender);		
	}

}
