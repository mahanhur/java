package variable;

public class P54 {

	public static void main(String[] args) {
		// boolean형
		boolean b1 = 109 > 5;
		
		// 정수
		int n1 = 10;
		long n2 = 0L;
		n2 = 2222222222222L;
		
		// 실수
		double d1 = 1.0;
		float f1 = 1.0F;
		
		double d2 = 1/2;
		System.out.println(d2);
		double d3 = 10.0/3.0;
		System.out.println(d3);
		float f2 = 10.0F/3.0F;
		System.out.println(f2);
	
		// char
		char c1 = 'A';
		System.out.println(c1);
		char c2 = 65;
		System.out.println(c2);
		
		//자료형간 연산
		int n3 = 10;
		double n4 = 10.0;
//		int result = n3 + n4;
		double result = n3 + n4;
		System.out.println(result);
	}

}
