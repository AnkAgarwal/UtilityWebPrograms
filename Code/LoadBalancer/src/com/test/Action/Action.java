package com.test.Action;

public class Action {

	
	public void performAction(int sleepDuration,String message){
		try {
				//synchronized (this) {				
					System.out.println(Thread.currentThread().getName()+"is executing "+message +"started");
					Thread.sleep(sleepDuration);
					System.out.println(Thread.currentThread().getName()+"is completed "+message +"completed");
				
				//}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
