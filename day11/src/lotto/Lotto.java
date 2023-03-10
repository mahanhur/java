package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Lotto {
	private HashSet<Integer> winningNum;
	private double prizeMoney;
	public Lotto() {
		winningNum = new HashSet<Integer>();
	}
	public Lotto(HashSet<Integer> winningNum, double prizeMoney) {
		this.winningNum = winningNum;
		this.prizeMoney = prizeMoney;
	}
	
	public void makeWinningNumberMoney() {
		//번호생성, 당첨금생성
		Random r = new Random();
		prizeMoney = r.nextInt(2000000000)+1;
		while(winningNum.size()<3) {
			int num = r.nextInt(25)+1;
			winningNum.add(num);
		}
		System.out.println(prizeMoney);
		System.out.println(winningNum.toString());
	}
	
	public int checkRanking(ArrayList<Integer> myNum) {
		int grade = 0;
		int cnt = 0;
		for(int num:myNum) {
			for(int pnum: winningNum) {
				if(num == pnum) {
					cnt++;
				}
			}
		}
					
		switch(cnt) {
		case 3: grade=1;break;
		case 2: grade=2;break;
		case 1: grade=3;break;
		}
		
		return 0;
	}
	
	public double prizeMoney(int grade) {
		double pMoney = 0.0;
		switch(grade) {
			case 1: pMoney = prizeMoney * 0.7; break;
			case 2: pMoney = prizeMoney * 0.2; break;
			case 3: pMoney = prizeMoney * 0.1; break;
		}
	return pMoney;
	}
	
}
