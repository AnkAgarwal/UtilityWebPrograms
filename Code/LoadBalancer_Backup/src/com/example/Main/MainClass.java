package com.example.Main;

import com.example.Queue.ProcessQueue;
import com.example.Scheduling.Manager;
import com.example.Thread.WorkerThread1;
import com.test.Action.Action;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numThread=3;
		//boolean[] flagArr = new boolean[numThread];
		
		ProcessQueue prcQueue=new ProcessQueue(numThread);
		
		for (int i = 0; i < 10; i++) {
			prcQueue.addItem(i+1+"");
		}
		
		
		
		Manager obj=new Manager();
		obj.RoundRobin(numThread, prcQueue);//, objAction, runArr, threadArr);
		
	}

}
