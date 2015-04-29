package src.com.Thread;

import src.com.Operations.Admin;

public class DepositThread extends Thread{

	String accountID;
	Admin admin;
	double amount;
	
	public DepositThread(String accountID,Admin admin, double amount){
		this.accountID=accountID;
		this.admin=admin;
		this.amount=amount;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		admin.depositAmount(accountID, amount);
		System.out.println("Amount for "+accountID+" deposited");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Balance for "+accountID+" is "+admin.getBalance(accountID)+" after deposit");
		
	}

}
