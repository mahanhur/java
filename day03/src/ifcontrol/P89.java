package ifcontrol;

public class P89 {

	public static void main(String[] args) {
		String grade = "";
		String gender = "M";
		double sum = 95.0;
		

		
//		//if else
//		if(gender.equals("M")) {
//			System.out.println("Male....");
//		} else {
//			System.out.println("Female....");
//		}
		
//		남자 이고 90점 이상이면 MVIP
//		여자 이고 90점 이상이면 FVIP
//		남자 이고 80점 이상이면 MGOLD
//		여자 이고 80점 이상이면 FGOLD
//		남자 이고 80점 미만이면 MNORMAL
//		여자 이고 80점 미만이면 FNORMAL
		
//		if(gender.equals("M")) {
//			if(sum>=90.0) {
//				grade = "MVIP";
//			} else if (sum>=80.0) {
//				grade = "MGOLD";
//			} else {
//				grade = "MNORMAL";
//			}
//		} else {
//			if(sum>=90.0) {
//				grade = "FVIP";
//			} else if (sum>=80.0) {
//				grade = "FGOLD";
//			} else {
//				grade = "FNORMAL";
//			}
//		}
		
		grade = (gender.equals("M")) ? (sum>=90.0) ? "MVIP" : (sum>=80.0) ? "MGOLD" : "MNORMAL" : (sum>=90.0) ? "FVIP" : (sum>=80.0) ? "FGOLD" : "FNORMAL";
		
//		grade = (gender.equals("M")) ? "Y" : "N";
		
//		switch (grade) {
//		case "FVIP":
//		case "MVIP":
//			sum += 100;
//			break;
//		case "FGOLD":
//		case "MGOLD":
//			sum += 90;
//			break;
//		default:
//			sum += 10;
//		}
		
		System.out.printf("%s, %s, %4.2f\n", grade, gender, sum);
		
		System.out.println("End....");
	}

}
