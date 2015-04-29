package com.sampleTest.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.sampleTest.Background.DeDuplicateThread;
import com.sampleTest.Threads.AddDataThread;
import com.sampleTest.Threads.DeleteDataThread;
import com.sampleTest.Threads.GetDataThread;
import com.sampleTest.Util.GlobalObjects;

public class MainCaller {
	
	//List created for testing, which stores the list returned by put operation and is used y get and delete for processing
	public static List<Integer> listToTest = new ArrayList<Integer>();
	public static void main(String[] args){
		GlobalObjects obj = new GlobalObjects();
		
		
		//Thread created to perform the operation
		AddDataThread threadToPut = new AddDataThread();
		DeleteDataThread threadToDelete = new DeleteDataThread();
		GetDataThread threadToGet = new GetDataThread();
		
		new Thread(threadToPut).start();
		new Thread(threadToDelete).start();
		new Thread(threadToGet).start();
		
	
		//Creating a scheduler task to run after every 3 sec in background with initial delay of 1sec
		//which checks for the de=duplication
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new DeDuplicateThread(), 1000, 3000, TimeUnit.MILLISECONDS);
	}

}
