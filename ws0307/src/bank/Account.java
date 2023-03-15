package bank;

public class Account {
	private String accNo;
	private String name;
	private String accHolder;
	private double balance;
	// Constructor - 음수 예외 상황
	
	public Account() {
	}
	
	public Account(String accNo, String name, String accHolder, double balance) throws Exceptions {
		if(balance < 0) {
			throw new Exceptions("음수입력 오류");
		}
		this.accNo = accNo;
		this.name = name;
		this.accHolder = accHolder;
		this.balance = balance;
		
	}

	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accNo + ", 계좌이름=" + name + ", 예금주=" + accHolder + ", 잔액=" + balance + "]";
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	// 계좌정보 조회

	public void check() {
		accNo = "8240";
		name = "요구불예금";
		accHolder = "허명현";
		balance = 10000;
		
		System.out.println("계좌번호: " +accNo +" 계좌이름: "+ name +" 예금주: "+ accHolder +" 잔액: "+ balance);
	}
	// 잔액 조회
	
	public double getBalance() {
		return balance;
	}
	
	// 입금 - 음수 예외 상황
	public void deposit(double money) throws Exceptions {
		if(money < 0) {
			throw new Exceptions("음수입력 오류");
		}
		this.balance += money;
		System.out.println("현재 잔액은 " + balance + "원 입니다.");
	}
	
	// 출금 - 잔액 부족 예외 상황, 음수 예외 상황
	public void withdraw(double money) throws Exceptions {
		balance = 10000;
		if(money < 0) {
			throw new Exceptions("음수입력 오류");
		} else if(this.balance < money) {
			throw new Exceptions("잔액부족 오류");
		}
		this.balance -= money;
		System.out.println("현재 잔액은 " + balance + "원 입니다.");
	}
	
}
