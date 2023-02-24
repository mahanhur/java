package whilecontrol;

public class P92 {

	public static void main(String[] args) {
		// 합과 평균을 구하시오

		System.out.println("Start");
		int cnt = 0;
		int sum = 0;
		double avg = 0.0;
		
		for (int i = 1; i <= 100; i++) {
			cnt++;
			sum += i;
		}
		avg = sum/(cnt*1.0);
		System.out.printf("%d, %4.2f\n", sum, avg);
		System.out.println("End");
	}

}
