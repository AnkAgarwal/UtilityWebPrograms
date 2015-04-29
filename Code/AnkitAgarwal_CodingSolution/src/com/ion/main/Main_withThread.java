package com.ion.main;

import com.ion.mutlithread.CreateTaskThread;
import com.ion.mutlithread.ExecuteTaskThread;
import com.ion.taskscheduler.TaskScheduler;

public class Main_withThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskScheduler schedule = new TaskScheduler();

		CreateTaskThread thread1 = new CreateTaskThread(schedule);
		ExecuteTaskThread thread2 = new ExecuteTaskThread(schedule);
		ExecuteTaskThread thread3 = new ExecuteTaskThread(schedule);
		ExecuteTaskThread thread4 = new ExecuteTaskThread(schedule);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
