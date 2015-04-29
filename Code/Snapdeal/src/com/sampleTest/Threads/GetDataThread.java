package com.sampleTest.Threads;

import com.sampleTest.Fetch.Fetch;
import com.sampleTest.Fetch.GetData;
import com.sampleTest.Main.MainCaller;

public class GetDataThread implements Runnable {

	@Override
	public void run() {
		Fetch obj = new GetData();
		while (true) {

			if (MainCaller.listToTest.size() > 0) {

				for (int iterator = 0; iterator < MainCaller.listToTest.size(); iterator++) {
					int idToRead = MainCaller.listToTest.get(iterator);
					obj.get(idToRead);
					System.out.println(idToRead + " is being read");
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
