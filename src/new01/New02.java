package new01;

import java.util.Scanner;

public class New02 {

	public static void main(String[] args) {
		// for문을 이용하여 사용
		// 숫자를 입력받아 1부터 입력한 수까지의 5의 배수 출력
		// 20 => 5 10 15 20
		// 30 => 5 10 15 20 25 30
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력 > ");
		int userNum = sc.nextInt();
		
		for(int i = 1; i <= userNum; i++) {
			if(i%5==0) System.out.print(i + " ");
		}
		sc.close();
	}

}
