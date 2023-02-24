package ifcontrol;

public class P86 {

	public static void main(String[] args) {
		String grade = "";
		String gender = "M";
		double sum = 80.0;
		
		//if문 기본
//		System.out.println("Start....");
//		if(grade.equals("VIP")) {
//			System.out.println("실행....");
//			return;
//		}
		
		//if else
		if(gender.equals("M")) {
			System.out.println("Male....");
		} else {
			System.out.println("Female....");
		}

		//삼항연산자 전환
//		(gender.equals("M")) ? "Male" : "Female";
		
		//if elseif
//		if(sum >= 90.0) {
//			grade = "VIP";
//		} else if(sum >= 70.0) {
//			grade = "GOLD";
//		} else {
//			grade = "SILVER";
//		}
		//삼항연산자 전환
		grade = (sum >= 90.0) ? "VIP" : (sum >= 70.0) ? "GOLD" : "SILVER";
		
		if(grade.equals("VIP")) {
			System.out.println("VIP 혜택 실행....");
		}
		
		System.out.printf("%s, %s, %4.2f\n", grade, gender, sum);
		
		System.out.println("End....");
	}

}
