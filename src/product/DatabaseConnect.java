package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	// DB 접속 => Singleton 객체로 생성
	// DB Driver, url, user, password
	// mysql : com.mysql.cj.jdbc.Driver
	// url : jdbc:mysql://localhost:3306/DB명
	// user : javaUser / pw : mysql
	private static DatabaseConnect dbc = new DatabaseConnect();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";	
	
	private DatabaseConnect() {
		// 객체가 생성될 때 DB 연결 경로/정보가 생성
		// 1. jdbc 드라이버를 로드하기 위해 사용되는 메서드
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "javaUser", "mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버를 로드할 수 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("url, user의 연결정보가 정확하지 않습니다.");
		} 
	}
	
	public static DatabaseConnect getInstance() {
		return dbc;
	}
	
	public Connection getConnection() {
		return conn;
	}
}	
