package ifcontrol;

import java.util.Scanner;

public class P93 {

	public static void main(String[] args) {
		// 숫자 4개를 입력 받는다.
		// 단, 항상 두 자릿수 이어야 한다.
		// 만약 2자리수가 아니면 프로그램 종료.
		Scanner sc = new Scanner(System.in);
		int ko = 0;
		int en = 0;
		int ma = 0;
		int si = 0;
		
		int sum = 0;
		double avg = 0;

		String grade = "";
		
		System.out.println("국어성적 입력:");
		ko = Integer.parseInt(sc.next());
			if(ko<10 || ko>=100) {
				sc.close();
				return;
			}
		System.out.println("영어성적 입력:");
		en = Integer.parseInt(sc.next());
			if(en<10 || en>=100) {
				sc.close();
				return;
			}
		System.out.println("수학성적 입력:");
		ma = Integer.parseInt(sc.next());
			if(ma<10 || ma>=100) {
				sc.close();
				return;
			}
		System.out.println("과학성적 입력:");
		si = Integer.parseInt(sc.next());
			if(si<10 || si>=100) {
				sc.close();
				return;
			}
		// 평균과 합계를 구한다.

			
			
		sum = (ko + en + ma + si);
		avg = sum/4.0;
		
		// 평균이 90이상이면 A
		// 평균이 80이상이면 B
		// 평균이 70이상이면 C
		// 평균이 60이상이면 D
		// 60미만이면 F
		
		if(avg>=90.0) {
			grade = "A";
		} else if(avg>=80.0) {
			grade = "B";
		} else if(avg>=70.0) {
			grade = "C";
		} else if(avg>=60.0) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		// 합계, 평균, 학점을 출력하시오.
		
		System.out.printf("%d, %4.2f, %s",sum, avg, grade);
		
		sc.close();
	}

}
