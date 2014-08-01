package com.example.Thread;

import com.example.Queue.ProcessQueue;
import com.test.Action.Action;

public class WorkerThread1 implements Runnable {

	public String message;
	public Action obj;
	
	public WorkerThread1(){    
		//this.obj=obj;
    } 
	
	public WorkerThread1(Action obj){    
		this.obj=obj;
    } 
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//obj.performAction(Integer.parseInt(message)*1000,message);
		message= obj.processQueue();
		if(message!=null)
			obj.performAction(2000,message);
		
		
	}
	
	
}
