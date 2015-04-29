package src.com.Thread;

import src.com.Operations.Admin;

public class WithDrawThread extends Thread{

	String accountID;
	Admin admin;
	double amount;
	
	public WithDrawThread(String accountID,Admin admin, double amount){
		this.accountID=accountID;
		this.admin=admin;
		this.amount=amount;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		admin.withdrawAmount(accountID, amount);
		System.out.println("Amount for "+accountID+" withdrawn");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Balance for "+accountID+" is "+admin.getBalance(accountID)+" after withdrawn");
		
	}

}
