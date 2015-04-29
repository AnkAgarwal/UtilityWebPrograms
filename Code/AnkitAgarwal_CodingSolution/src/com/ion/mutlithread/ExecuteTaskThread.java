package com.ion.mutlithread;

import com.ion.taskscheduler.TaskScheduler;

public class ExecuteTaskThread extends Thread {

	TaskScheduler taskScheduler;

	public ExecuteTaskThread(TaskScheduler scheduler) {
		this.taskScheduler = scheduler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (taskScheduler.getTaskList().size() > 0) {
			taskScheduler.executeByPriority();
		}
	}

}
