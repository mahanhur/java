package whilecontrol;

public class P95 {

	public static void main(String[] args) {
		System.out.println("Start");
		int i = 1;
		int sum = 0;
		int cnt = 0;
		double avg = 0;

		while (i <= 100) {
			if (i % 2 == 0) {
				sum += i;
				cnt++;
			}
			if(i == 80) {
				break;
			}
			i++;
		}

		avg = sum / (cnt * 1.0);

		System.out.printf("%d, %4.2f\n", sum, avg);

		System.out.println("End");
	}

}
