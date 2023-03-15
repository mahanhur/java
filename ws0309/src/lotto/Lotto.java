package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Lotto {
	private int winningNum;
	private double prizeMoney;

	Random r = new Random();
	HashSet<Integer> winningNums = new HashSet<Integer>();
	int i = winningNums.size();

	public void makeWinningNumberMoney() {

		for (i = 0; i < 3; i++) {
			winningNums.add(r.nextInt(24) + 1);
		}
		prizeMoney = r.nextInt(1999999999) + 1;
//		System.out.println(prizeMoney);
//		System.out.println(winningNums.toString());
	}

	ArrayList<Integer> myNums = new ArrayList<Integer>();
	int getPoint = 0;

	public int checkRanking(int myNum1, int myNum2, int myNum3) {
		myNums.add(myNum1);
		myNums.add(myNum2);
		myNums.add(myNum3);

		for (int data : myNums) {
			for (int data1 : winningNums) {
				if (data == data1) {
					getPoint++;
				}
			}
		}

		System.out.println(getPoint + "개 맞추심");
		return getPoint;
	}

	int grade = 0;
	double money = 0;

	public double prizeMoney() {
		switch (getPoint) {
		case 3:
			grade = 1;
			money = (prizeMoney / 20) * 14;
			break;
		case 2:
			grade = 2;
			money = (prizeMoney / 20) * 4;
			break;
		case 1:
			grade = 3;
			money = (prizeMoney / 20) * 2;
			break;
//		defualt :
//			throw new Exception("꽝입니다");
		}
//		System.out.println(prizeMoney);
//		System.out.println(money);
		System.out.print("당첨번호는");
		System.out.print(winningNums.toString());
		System.out.print("였습니다.");
		System.out.println();
		System.out.printf("%d등 당첨! 상금은 %10.2f원 입니다! 축하합니다!\n", grade, money);
		System.out.println("-------------------------------");
		return grade;
	}

}