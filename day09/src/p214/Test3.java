package p214;

import java.io.IOException;
import java.io.InputStreamReader;

public class Test3 {

	public static void main(String[] args) {
		double a = 0;
		double result = 10 / a;
		System.out.println(result);
		//2초간 정지
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		//예외가 뭔지 개발자에게 보여줌(콘솔에)
			e.printStackTrace();
		}
		
		InputStreamReader ir = new InputStreamReader(System.in);
		System.out.println("Input Character...");
		int b = 0;
		try {
			b = ir.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(b);
		System.out.println("End..");
		
	}

}
