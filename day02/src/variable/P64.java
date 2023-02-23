package variable;

public class P64 {

	public static void main(String[] args) {
		int a = 10;
		double d  = 10.2345;
		String str1 = "abc";
		String str2 = "abc";
		System.out.printf("%d %4.4f %s \n",a,d,str1);
		if(str1 == str2) {
			System.out.println("OK");
		}
		if(str1.equals(str2)) {
			System.out.println("OK2");
		}
		String str3 = new String("abc");
		
		if(str1 == str3) {
			System.out.println("OK3");
		} else {
			System.out.println("NOTOK3");
		}
		if(str1.equals(str3)) {
			System.out.println("OK4");
		}		
		str1 = "def";
	}

}
