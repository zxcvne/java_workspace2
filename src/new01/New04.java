package new01;

import java.util.HashMap;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		// 단어장
		// map 단어 : 의미
		// 입력받을 단어의 개수를 입력 => 개수만큼 map 추가
		// 콘솔에 출력
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		
		System.out.println("단어장 만들기");
		System.out.print("입력할 개수를 입력 > ");
		int size = sc.nextInt();
		sc.nextLine();
		
		while(map.size() < size) {
			System.out.print("단어를 입력 > ");
			String word = sc.nextLine();
			System.out.print("뜻을 입력 > ");
			String mean = sc.nextLine();
			map.put(word.trim(), mean.trim());
		}
		
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
		sc.close();
	}

}
