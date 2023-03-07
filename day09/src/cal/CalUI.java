package cal;

import java.util.Scanner;

public class CalUI {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input 2 Numbers..");
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		double result;
		try {
			result = Cal.div(a, b);
			System.out.println(result);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("오류임");
		}
		
				
		sc.close();
	}
}
