package com.example.Thread;

import com.example.Queue.ProcessQueue;
import com.test.Action.Action;

public class WorkerThread1 implements Runnable {

	private String message;
	private int threadPos=0;
	Action obj;
	
	public WorkerThread1(){    
    } 
	
    public WorkerThread1(String s,int threadPos,Action obj){  
        this.message=s; 
        this.threadPos=threadPos;
        this.obj=obj;
    } 
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//obj.performAction(Integer.parseInt(message)*1000,message);
		obj.performAction(2000,message);
		ProcessQueue.completeArr[threadPos]=ProcessQueue.completeArr[threadPos]+1;
		
	}
	
	
}
