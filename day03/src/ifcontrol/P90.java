package ifcontrol;

public class P90 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		// 두 가지 수의 최대 값과 최소 값을 구하시오
		int max = 0;
		int min = 0;
		
		if(a>b) {
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		}
//			
//		if(a>b) {
//			if(a>c) {
//				max = a;
//				if(b>c) 
//			} else 
//		}
		System.out.printf("Max: %d, Min: %d", max, min);
	}

}
