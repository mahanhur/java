package p214;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		int num = 0;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Input num...");
			num = Integer.parseInt(sc.next());
			int result = 10 / num;
			System.out.println(result);
		} catch (Exception E1) {
			System.out.println("잘못입력하셨습니다.");

		}

		System.out.println("End Application...");
	}

}
