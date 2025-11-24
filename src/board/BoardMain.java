package board;

import java.io.IOException;
import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		BoardController bc = new BoardController();
		int menu = 0;
		
		bc.defaultBoard();
		do {
			menu = bc.menuPrint(sc);
			switch(menu) {
			case 1: bc.printBoard(); break;
			case 2: bc.addBoard(sc); break;
			case 3: bc.searchBoard(sc); break;
			case 4: bc.modifyBoard(sc); break;
			case 5: bc.removeBoard(sc); break;
			case 6: bc.fileBoard(); break;
			case 7: System.out.println("종료"); break;
			default : 
				System.out.println("잘못된 메뉴");
			}
			
		}while(menu != 7);
	}

}
