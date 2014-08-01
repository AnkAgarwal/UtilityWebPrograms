package com.test.Action;

import com.example.Queue.ProcessQueue;

public class Action {

	public int turnVariable;
	public ProcessQueue prcQueue;
	
	/*public Action(){
		turnVariable=1;
	}*/
	public void populateQueue(){
		prcQueue=new ProcessQueue();
		
		for (int i = 0; i < 12; i++) {
			if(i==0)
				prcQueue.addItem(10+"");
			else
				prcQueue.addItem(2+"");
		}
		
		/*for (int i = 0; i < 12; i++) {
			prcQueue.addItem(i+"");
		}*/
	}
	public void performAction(int sleepDuration,String message){
		try {
				//synchronized (this) {				
					System.out.println(Thread.currentThread().getName()+"is executing "+message +"started");
					Thread.sleep(Integer.parseInt(message)*1000);
					System.out.println(Thread.currentThread().getName()+"is completed "+message +"completed");
				
				//}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String processQueue(){
		String retVal=null;
		synchronized (this) {	
			
			if(Thread.currentThread().getName().equals(turnVariable+"")){
				retVal =prcQueue.removeItem(0);
				turnVariable=(turnVariable+1)%3;
				notifyAll();
			}else{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return retVal;
	}

}
