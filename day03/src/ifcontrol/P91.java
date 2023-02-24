package ifcontrol;

public class P91 {

	public static void main(String[] args) {
		int a = 30;
		int b = 50;
		int c = 60;

		// 세 가지 수의 최대 값과 최소 값을 구하시오
		int max = 0;
		int min = 0;

		//나의 풀이
		if (a > b) {
			if (a > c) {
				if (b > c) {
					max = a;
					min = c;
				} else {
					max = a;
					min = b;
				}
			} else {
				max = c;
				min = b;
			}
		} else {
			if (a > c) {
				max = b;
				min = c;
			} else {
				if (b > c) {
					max = b;
					min = a;
				} else {
					max = c;
					min = a;
				}
			}
		}

		System.out.printf("Max: %d, Min: %d", max, min);

		//&&조건 이용
		if (a > b && a > c) {
			max = a;
			if (b > c) {
				min = c;
			} else {
				min = b;
			}
		} else if (b < a && b > c) {
			max = b;
			if (a > c) {
				min = c;
			} else {
				min = a;
			}
		} else if (c > a && c > b) {
			max = c;
			if (a > b) {
				min = b;
			} else {
				min = a;
			}
		}
		
		//삼항연산자 이용
		max = (a>b)? ((a>c)? a:c) : (b>c)? b:c;
		min = (a<b)? ((a<c)? a:c) : (b<c)? b:c;
		
		//max api 이용
		if(a>b) {
			max = Math.max(c, a);
			min = Math.min(c, b);
		} else {
			max = Math.max(c, b);
			min = Math.min(c, a);
		}

		System.out.printf("Max: %d, Min: %d", max, min);
	}

}
