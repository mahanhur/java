package variable;

public class P69 {

	public static void main(String[] args) {
//		String str = "abcdef";
//		str = str.toUpperCase();
//		System.out.println(str);
//		
//		String str2 = str.replace("A", "Z");
//		System.out.println(str2);
//		
//		int lng = str.length();
//		System.out.println(lng);
//		
//		int t = str.indexOf("B");
//		System.out.println(t);
//		
//		char str3 = str.charAt(0);
//		System.out.println(str3);
//		
//		String str4 = str.substring(1,3);
//		System.out.println(str4);
		
		String email = "hello2665@navertt.com";
		
		int at = email.indexOf("@");
		int lng = email.length();
		System.out.println(at);
		System.out.println(lng);
				
		String id = email.substring(0,at);
		String domain = email.substring((at+1), lng);
		
		System.out.printf("%s , %s", id, domain);
		
		
	}

}

