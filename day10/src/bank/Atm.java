package bank;

public class Atm {

	public static void main(String[] args) {
		Account acc1 = null;
		try {
			acc1 = new Account(10000);
			System.out.println(acc1);
			acc1.withdraw(-1000);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(MakeMessage.makeMessage(e.getMessage()));
//			System.out.println(e.getMessage());
		}
	}

}
