package com.example.Scheduling;

import com.example.Main.MainClass;
import com.example.Queue.ProcessQueue;
import com.example.Thread.WorkerThread1;
import com.test.Action.Action;

public class Manager {
	
	Action objAction=null;
	Runnable[]  runArr=null;
	Thread[] threadArr=null;
	
	public void createThreadObject(int numThread){
	
		objAction=new Action();
		runArr=new WorkerThread1[numThread];
		threadArr=new Thread[numThread];
	}

	public void RoundRobin(int numThread, ProcessQueue prcQueue){
		MainClass obj=new MainClass();
		createThreadObject(numThread);
		while(prcQueue.isEmpty()==false){
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < numThread; i++) {
			
				if(ProcessQueue.completeArr[i] == ProcessQueue.startArr[i] && prcQueue.isEmpty()==false){
					if((i!=0 && ProcessQueue.startArr[i-1] == ProcessQueue.startArr[i]+1) || 
							i==0 && ProcessQueue.startArr[i] == ProcessQueue.startArr[numThread-1]){
					
						runArr[i]=new WorkerThread1(prcQueue.removeItem(0),i,objAction);
						threadArr[i]=new Thread(runArr[i],i+1+"");
						threadArr[i].setPriority(10);
						
						ProcessQueue.startArr[i]=ProcessQueue.startArr[i]+1;
						System.out.println(i+1+" Thread "+" has started");
						threadArr[i].start();
						
					}
				}
			}
			
		}	
		
	}
}
