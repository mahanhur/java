package cal;

import java.util.Scanner;

public class CalUI2 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input 2 Numbers..");
		double a = Double.parseDouble(sc.next());
		double b = Double.parseDouble(sc.next());
		double result;
		try {
			result = Cal.div(a, b);
			System.out.println(result);
		} catch (InfinityException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
				
		sc.close();
	}
}
