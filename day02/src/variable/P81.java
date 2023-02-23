package variable;

import java.util.Scanner;

public class P81 {

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
//		String strS = S.next();
//		int a = Integer.parseInt(strS);
		int a = Integer.parseInt(S.next());
		String result = (a > 0) ? "정상" : "비정상";
		System.out.println(result);
		S.close();
	}

}
