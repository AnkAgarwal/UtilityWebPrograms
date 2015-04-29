package com.sampleTest.Threads;

import java.io.File;
import java.io.IOException;

import com.sampleTest.Insert.Insert;
import com.sampleTest.Insert.PutData;
import com.sampleTest.Main.MainCaller;
import com.sampleTest.Util.Utility;

public class AddDataThread implements Runnable {

	@Override
	public void run() {
		File folder = new File("input");
		if (folder.isDirectory()) {
			for (File fileEntry : folder.listFiles()) {
				Insert putObj = new PutData();
				try {
					int insertedID =  putObj.put(Utility.readFile(fileEntry.getPath()));
					MainCaller.listToTest.add(insertedID);
					System.out.println(insertedID + "has been inserted successfully");
					Thread.sleep(1000);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
