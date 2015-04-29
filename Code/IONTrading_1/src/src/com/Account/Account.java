package src.com.Account;

public class Account {

	/**
	 * @param args
	 */
	static int count = 1;

	private String id;
	private String userName;
	private double balance;

	public Account(String name) {
		this.balance = 0;
		this.userName = name;
		this.id = generateAccountNumber();
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.userName;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	private synchronized String generateAccountNumber() {
		String keyword = "HDFCACCOUNT_";
		String bankAccount = keyword + count;
		count++;
		return bankAccount;
	}

}
