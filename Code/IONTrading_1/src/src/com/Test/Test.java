package src.com.Test;

import src.com.Operations.Admin;
import src.com.Thread.DepositThread;
import src.com.Thread.TransferThread;
import src.com.Thread.WithDrawThread;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Admin admin=new Admin();
		
		String Ram_1 = admin.createAccount("Ram");
		String Ram_2 = admin.createAccount("Ram");
		
		
		//Case1
		DepositThread deposit1=new DepositThread(Ram_1,admin,5000);
		DepositThread deposit2=new DepositThread(Ram_2,admin,5000);
		
		deposit1.start();
		deposit2.start();
		
		try {
			deposit1.join();
			deposit2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------");
		//Case2
		WithDrawThread withDraw1=new WithDrawThread(Ram_1,admin,2000);
		WithDrawThread withDraw2=new WithDrawThread(Ram_2,admin,2000);
		
		withDraw1.start();
		withDraw2.start();
		
		try {
			withDraw1.join();
			withDraw2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------");
		
		//Case3
		/*TransferThread transfer=new TransferThread(Ram_1, Ram_2, admin, 2000);
		WithDrawThread withDraw=new WithDrawThread(Ram_2,admin,2000);
		
		transfer.start();
		withDraw.start();*/

	}

}
