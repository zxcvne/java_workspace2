package board;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardController implements BoardInterface{
//	private int num;
//	private String title;
//	private String writer;
//	private String contents;
//	private String regDate;
	private List<Board> boardList = new ArrayList<>();	
	Scanner scan = new Scanner(System.in);

	public void defaultBoard() {
		boardList.add(new Board("처음 등록되는 글","테스터","처음 등록한 글 입니다."));
		boardList.add(new Board("2번 글","테스터","2번 글 입니다."));
		boardList.add(new Board("3번 글","테스터","3번 글 입니다."));
	}
	
	public int menuPrint(Scanner scan) {
		System.out.println("	  --menu--");
		System.out.println("1.전체 보기 | 2.게시글 추가 | 3. 게시글 조회");
		System.out.println("4. 게시글 수정 | 5. 게시글 삭제  | 6. 게시글 파일 출력");
		System.out.println("7.종료");
		System.out.println("menu > ");
		return scan.nextInt();
	}
	
	@Override
	public void addBoard(Scanner scan) {
		scan.nextLine();
		System.out.println("title > ");
		String title = scan.nextLine();
		System.out.println("writer > ");
		String writer = scan.nextLine();
		System.out.println("contents > ");
		String contents = scan.nextLine();
		boardList.add(new Board(title,writer,contents));
	}
	
	@Override
	public void printBoard() {
		boardList.forEach(n-> {n.print();});
	}

	@Override
	public void searchBoard(Scanner scan) {
		System.out.println("글 번호 >");
		int num = scan.nextInt();
//		boardList.forEach(n->{
//		if(n.getNum() == num) {
//			n.print();
//		}}
//		);
		int index = boardList.indexOf(new Board(num));
		if(index != -1) {
			boardList.get(index).print();
			return;
		}
		System.out.println("일치하는 게시글이 없습니다.");
		
	}

	@Override
	public void modifyBoard(Scanner scan) {
		System.out.println("글 번호 >");
		int num = scan.nextInt();
		int index = boardList.indexOf(new Board(num));
		scan.nextLine();
		if(index != -1) {
			System.out.println("제목 >");
			String title = scan.nextLine();
			System.out.println("내용 >");
			String contents =scan.nextLine();

			Board tmp = boardList.get(index);
			tmp.setTitle(title.trim());
			tmp.setContents(contents.trim());
			LocalDateTime l = LocalDateTime.now(); 
			tmp.setRegDate(l.toString().substring(0,l.toString().indexOf("T")));
			return;
		}
//		boardList.forEach(n->{
//		if(n.getNum() == num ) {
//			System.out.println("제목 >");
//			String title = scan.nextLine();			
//			System.out.println("저자 >");
//			String writer=scan.nextLine();
//			System.out.println("내용 >");
//			String contents =scan.nextLine();
//			n.setTitle(title.trim());
//			n.setWriter(writer.trim());
//			n.setContents(contents.trim());
//			System.out.println("게시글 수정 완료");
//			return;
//			}
//		});
		System.out.println("게시글이 없습니다.");
	}

	@Override
	public void removeBoard(Scanner scan) {
		System.out.println("글 번호 >");
		int num = scan.nextInt();
		int index = boardList.indexOf(new Board(num));
		if(index != -1) {
			boardList.remove(index);
			System.out.println("게시글 삭제 완료");
			return;
		}
		System.out.println("일치하는 게시글이 없습니다.");
		
//		for(int i = 0; i < boardList.size();  i++) {
//			if(boardList.get(i).getNum() == num) {
//				boardList.remove(i);
//				System.out.println("게시글 삭제 완료");
//		}
//		};
	}

	@Override
	public void fileBoard() {
		try {
			FileWriter fw = new FileWriter("board.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			StringBuffer sb = new StringBuffer();
			String data = "";
			int cnt = 0;
			
			while(cnt<boardList.size()) {
				sb.append(boardList.get(cnt).toString());
				sb.append("\r\n");
				cnt++;
			}
			data = sb.toString();
			System.out.println(data);
			fw.write(data);
			System.out.println("파일 기록 완료");
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
