package lotto;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("로또게임을 시작합니다.");
		while(true) {
			System.out.println("커맨드 입력: s(게임시작), q(그만하기)");
			String cmd = sc.next();
			if(cmd.equals("s")) {
				Lotto game = new Lotto();
				System.out.println("숫자3개입력");
				int myNum1 = sc.nextInt();
				int myNum2 = sc.nextInt();
				int myNum3 = sc.nextInt();
				
				game.makeWinningNumberMoney();
				game.checkRanking(myNum1, myNum2, myNum3);
				game.prizeMoney();
			} else if (cmd.equals("q")) {
				System.out.println("bye");
				break;
			}
			
		}
	}

}