package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		DatabaseConnect dbc = DatabaseConnect.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public int insert(Product p) {
		// DB에 객체 등록
		query ="INSERT INTO product(pname, price, madeby) VALUES (?, ?, ?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			
			// insert, update, delete => executeUpdate() return (처리된 개수)
			return pst.executeUpdate(); // 1 
			
		} catch (SQLException e) {
			System.out.println("insert 구문 에러");
			e.printStackTrace();
		}
		return 0;
	}
	
	List<Product> list = new ArrayList();
	
	@Override
	public List<Product> getList() {
		// select * from product => return list
		query = "SELECT * FROM product ORDER BY pno DESC";
		try {
			pst = conn.prepareStatement(query);
			// excuteQuery() => return ResultSet
			// select return => ResultSet 객체로 리턴
			
			ResultSet rs = pst.executeQuery();
			
			// resultset => List로 변환 리턴
//			(int pno, String pname, int price, String regdate)
			while(rs.next()) {
				list.add(new Product(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"))
				);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("getList 구문 에러");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getDetail(int pno) {
		query = "SELECT * FROM product WHERE pno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new Product(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby")
					);
			}
		} catch (SQLException e) {
			System.out.println("getDetail 구문 에러");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int modify(Product p) {
		query = "UPDATE product "
				+ "SET pname=?, price=?, madeby=?, regdate=now() "
				+ "WHERE pno=?";
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, p.getPname());
				pst.setInt(2, p.getPrice());
				pst.setString(3, p.getMadeby());
				pst.setInt(4, p.getPno());
				
				return pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println("modify 구문 에러");
				e.printStackTrace();
			}
		
		return 0;
	}

	@Override
	public int remove(int pno) {
		query = "DELETE FROM product WHERE pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("remove 구문 에러");
			e.printStackTrace();
		}
		return 0;
	}
	
}
