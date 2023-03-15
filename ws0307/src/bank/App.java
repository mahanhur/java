package bank;

import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] arg) {
		// 계좌생성
		Account acc = new Account();
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("원하는 거래를 입력하세요[계죄생성a, 계좌정보조회b, 입금c, 출금d]");
		String cmd = sc.next();
		if(cmd.equals("a")) {
//			System.out.println("계좌번호 입력");
//			String accNo = sc.next();
			String accNo = Integer.toString(r.nextInt(10000)+1);
			System.out.println("계좌이름 입력");
			String name = sc.next();
			System.out.println("예금주 입력");
			String accHolder = sc.next();
			System.out.println("잔액 입력");
			double balance = Double.parseDouble(sc.next());
			try {
				acc = new Account(accNo, name, accHolder, balance);
				System.out.println(acc);
			} catch (Exceptions e) {
//				e.printStackTrace();
				e.getMessage();
			}
		} else if(cmd.equals("b")) {
			// 계좌 정보 조회
			System.out.println("계좌번호를 입력해주세요");
			String cmd1 = sc.next();
			if(cmd1.equals("8240")) {
				acc.check();
			}
			
		} else if(cmd.equals("c")) {
			// 계좌 입금
			System.out.println("입금하실 금액을 입력하세요");
			double money = Double.parseDouble(sc.next());
			
			try {
				acc.deposit(money);
			} catch (Exceptions e) {
//				e.printStackTrace();
				e.getMessage();
			}
		} else if(cmd.equals("d")) {
			// 계좌 출금
			System.out.println("출금하실 금액을 입력하세요");
			double money = Double.parseDouble(sc.next());
			
			try {
				acc.withdraw(money);
			} catch (Exceptions e) {
//				e.printStackTrace();
				e.getMessage();
			}
		}

		}
		}

	private static String ToString(int i) {
		return null;
	}

	}

