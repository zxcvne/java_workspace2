package board;

import java.time.LocalDateTime;
import java.util.Objects;

public class Board {
	
	// 번호가 일치하면 같은 게시물로 인지 => equals 추가
	// 각 객체는 독립적 / 번호는 하나의 번호를 참조	
	// 번호는 자동증가 => static
	// 작성일 오늘 날짜를 자동으로 추가
	
	private static int count; // 자동증가 count
	private int num;
	private String title;
	private String writer;
	private String contents;
	private String regDate;
	
	public Board() {
		count++;// 자동 번호 증가
		this.num = count;
		LocalDateTime ldt = LocalDateTime.now();
		this.regDate = ldt.toString().substring(0,ldt.toString().indexOf("T"));
	}
	
	public Board(String title, String writer, String contents) {
		this(); // 기본 생성자 실행
		this.title = title;
		this.writer = writer;
		this.contents = contents;
	}
	
	// equals용 객체
	public Board(int num) {
		this.num = num;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return num == other.num;
	}
	
	public void print() {
		// 하나의 게시글 출력 메서드
		System.out.println("---------------------------");
		System.out.println("num:" + this.num);
		System.out.println("title:" + this.title);
		System.out.println("writer:" + this.writer + "(" + this.regDate +")");
		System.out.println("contents:");
		System.out.println(this.contents);
	}

	@Override
	public String toString() {
		return "[num=" + num + ", title=" + title + ", writer=" + writer + ", contents=" + contents + ", regDate="
				+ regDate + "]";
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
