package com.sampleTest.Threads;

import com.sampleTest.Main.MainCaller;
import com.sampleTest.Remove.DeleteData;
import com.sampleTest.Remove.Remove;

public class DeleteDataThread implements Runnable {

	@Override
	public void run() {

		while (true) {

			if (MainCaller.listToTest.size() > 3) {
				int idToDelete = MainCaller.listToTest.get(0);
				Remove obj = new DeleteData();
				obj.delete(idToDelete);
				MainCaller.listToTest.remove(0);
				System.out.println(idToDelete
						+ " has been deleted successfully");

			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
