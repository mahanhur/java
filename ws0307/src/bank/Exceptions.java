package bank;

public class Exceptions extends Exception{
	public Exceptions() {
		
	}
	public Exceptions(String msgcode) {
		System.out.println(msgcode);
	}
}
