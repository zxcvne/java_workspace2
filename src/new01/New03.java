package new01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class New03 {

	public static void main(String[] args) {
		// Collection Framework
		// Framework : 개발을 효율적으로 도와주는 개발도구
		// list set map
		// List : 배열처럼 사용. index가 있음, 순서를 보장, 중복 가능
		// Set : index가 없음, 순서를 보장하지 않음, 중복 불가능
		// Map : key value 쌍으로 저장, key 중복X, 순서 보장X 
		// value : key가 같으면 value는 덮어씀.
		// * Map의 key는 Set임
		
		ArrayList<Integer> list = new ArrayList<>(); // 자식 객체로 생성
		List<Integer> list2 = new ArrayList<>(); // 부모 객체로 생성
		
		for(int i=1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		// map을 이용하여 이름/점수 형태로 3명을 입력하고, 출력
		Map<String, Integer> map = new HashMap<>();
		map.put("홍길동", 80); 
		map.put("이순신", 60); 
		map.put("강감찬", 70);
		System.out.println(map);
		for(String key : map.keySet()) {
			System.out.println(key +" : " + map.get(key));
		}
		
	
	}

}
