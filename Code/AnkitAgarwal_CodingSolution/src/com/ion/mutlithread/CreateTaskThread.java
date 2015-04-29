package com.ion.mutlithread;

import com.ion.task.Task;
import com.ion.taskscheduler.TaskScheduler;

public class CreateTaskThread extends Thread {

	TaskScheduler taskScheduler;

	public CreateTaskThread(TaskScheduler scheduler) {
		this.taskScheduler = scheduler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Task myTask = new Task(i, "Task" + i, i);
			this.taskScheduler.getTaskList().add(myTask);
		}
	}

}
