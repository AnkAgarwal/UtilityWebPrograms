package com.example.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.Thread.WorkerThread;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> processQueue=new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			processQueue.add(i+1+"");
		}
		ExecutorService service=Executors.newFixedThreadPool(3);
		int queueSize=processQueue.size();
		for (int i = 0; i < queueSize; i++) {
			String message=processQueue.get(0);
			processQueue.remove(0);
			Runnable worker=new WorkerThread(message);
			service.execute(worker);
		}
		service.shutdown();
		
		while(service.isTerminated() == false){
			
		}
		
		System.out.println("Program completed");
	}

}
