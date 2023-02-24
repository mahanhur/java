package ifcontrol;

public class P88 {

	public static void main(String[] args) {
		String grade = "";
		String gender = "M";
		double sum = 70.0;

		//if else
		if(gender.equals("M")) {
			System.out.println("Male....");
		} else {
			System.out.println("Female....");
		}

//		100 ~ 95 또는 90 ~ 85 VIP
//		80~75 또는 60 ~ 65 GOLD
//		나머지는 NORMAL
		
		
		//if elseif
		if(sum >= 85.0 && (sum <= 90.0 || sum >= 95.0)) {
			grade = "VIP";
		} else if((sum >= 60.0 && sum <= 65.0) || (sum <= 80.0 && sum >= 75.0)) {
			grade = "GOLD";
		} else {
			grade = "NORMAL";
		}
		
		if(grade.equals("VIP")) {
			System.out.println("VIP 혜택 실행....");
		}
		
		System.out.printf("%s, %s, %4.2f\n", grade, gender, sum);
		
		System.out.println("End....");
	}

}
