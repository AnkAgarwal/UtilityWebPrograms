package src.com.Thread;

import src.com.Operations.Admin;

public class TransferThread extends Thread{

	String fromAccountID;
	String toAccountID;
	Admin admin;
	double amount;
	
	public TransferThread(String fromAccountID,String toAccountID,Admin admin, double amount){
		this.fromAccountID=fromAccountID;
		this.toAccountID=toAccountID;
		this.admin=admin;
		this.amount=amount;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		admin.transferFund(fromAccountID, toAccountID, amount);
		System.out.println("Amount is being transferred from "+fromAccountID+" to "+toAccountID);
		System.out.println("Balance for "+fromAccountID+" is "+admin.getBalance(fromAccountID));
		System.out.println("Balance for "+toAccountID+" is "+admin.getBalance(toAccountID));
		
	}

}
