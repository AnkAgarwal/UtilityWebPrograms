package com.example.Scheduling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.Main.MainClass;
import com.example.Queue.ProcessQueue;
import com.example.Thread.MyThreadFactory;
import com.example.Thread.WorkerThread1;
import com.test.Action.Action;

public class Manager {
	
	Action objAction=null;
	Runnable[]  runArr=null;
	Thread[] threadArr=null;
	ProcessQueue pQueue=null;
	
	public void createThreadObject(int numThread){
	
		objAction=new Action();
		runArr=new WorkerThread1[numThread];
		threadArr=new Thread[numThread];
		//pQueue=ProcessQueue.getInstance();
	}

	public void RoundRobin(int numThread){
		MainClass obj=new MainClass();
		createThreadObject(numThread);
		Action objAction=new Action();
		objAction.populateQueue();
		/*for (int i = 0; i < numThread; i++) {
			runArr[i]=new WorkerThread1(objAction);
			threadArr[i]=new Thread(runArr[i],i+"");
		}*/
		MyThreadFactory myThreadFactoryObj=new MyThreadFactory();
		ExecutorService service=Executors.newFixedThreadPool(numThread,myThreadFactoryObj);
		/*int queueSize=processQueue.size();
		for (int i = 0; i < queueSize; i++) {
			String message=processQueue.get(0);
			processQueue.remove(0);
			Runnable worker=new WorkerThread(message);
			service.execute(worker);
		}
		service.shutdown();*/
		while(objAction.prcQueue.isEmpty() == false){
			//for (int i = 0; i < numThread; i++) {
				//if (threadArr[objAction.turnVariable].isAlive()==false){
					//runArr[i]=new WorkerThread1(objAction);
					//threadArr[i]=new Thread(runArr[i],i+"");
					Runnable worker=new WorkerThread1(objAction);
					service.execute(worker);
					//System.out.println(i+" Thread "+" has started");
					//threadArr[objAction.turnVariable].start();	
				//}
			//}
		}
		service.shutdown();
		while(service.isTerminated() == false){
			
		}
	}
}

