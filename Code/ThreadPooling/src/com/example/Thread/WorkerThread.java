package com.example.Thread;

public class WorkerThread implements Runnable {

	private String message; 
	
    public WorkerThread(String s){  
        this.message=s;  
    } 
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		performAction(2000);
		
	}
	
	public void performAction(int sleepDuration){
		try {
			System.out.println(message +"started");
			Thread.sleep(sleepDuration);
			System.out.println(message +"completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
