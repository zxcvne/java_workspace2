package board;

import java.util.Scanner;

public interface BoardInterface {
	// 게시판 프로그램
	/* 1. 게시글 추가
	 * 2. 게시글 리스트 보기
	 * 3. 게시글 상세보기
	 * 4. 게시글 수정
	 * 5. 게시글 삭제
	 * 6. 게시글 파일로 전송 
	 * */
	
	void addBoard(Scanner scan);
	void printBoard();
	void searchBoard(Scanner scan);
	void modifyBoard(Scanner scan);
	void removeBoard(Scanner scan);
	void fileBoard();
	
	/* Board class => 게시글 객체 생성용도 (num, title, writer, contents, regDate);
	 * BoardMain => menu 를 띄워서 콘솔에서 입력받고, 출력할 용도
	 * BoardController class => 기능 구현 => interface 구현
	 * 
	 * */
}
