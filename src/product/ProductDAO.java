package product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDAO implements ProductDAOInterface {
	// service <-> DAO <-> DB
	// DBConnection <-> DAO
	// DB에 접근하는 객체를 처리 (주고, 받고)
	
	// DB 연결 객체
	private Connection conn; // java.sql.Conneciton을 import
	// 외부 라이브러리 mysql-connector가 없으면 import가 안됨 
	// 있는데도 import가 안되면 설치중 JAR파일이 손상되었을수 있으므로 라이브러리 재설치
	
	//sql 구문을 실행시키는 역할을 하는 객체
	private PreparedStatement pst;
	
	// sql 쿼리문 저장 스트링
	private String query ="";
	
	public ProductDAO() {
		// DBConnection class 연결 (싱글톤)
	}
	
}
