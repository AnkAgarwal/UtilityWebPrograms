package com.ion.taskscheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ion.task.Task;

public class TaskScheduler {

	private List<Task> taskList;

	public List<Task> getTaskList() {
		return taskList;
	}

	public TaskScheduler(List<Task> tasks) {
		taskList = tasks;
	}

	public TaskScheduler() {
		taskList = new ArrayList<Task>();
	}

	public void executeAll() {
		// TODO Auto-generated method stub
		if (this.taskList != null) {
			while (this.taskList.size() > 0) {
				Task task = this.taskList.get(0);
				task.execute();
				taskList.remove(0);
			}
		}
	}

	public void executeAllByPriority() {
		// TODO Auto-generated method stub
		if (this.taskList != null) {
			while (this.taskList.size() > 0) {
				//Create a new list and sort it on the basis of priority
				List<Task> sortedList = new ArrayList<Task>(this.taskList);
				Collections.sort(sortedList);
				Task task = sortedList.get(0);
				task.execute();
				this.taskList.remove(task);
			}
		}
	}

	public synchronized void executeByPriority() {
		// TODO Auto-generated method stub
		
		//Check for any task present in the task scheduler
		if (this.taskList != null && this.taskList.size() > 0) {
			//Create a new list and sort it on the basis of priority
			List<Task> sortedList = new ArrayList<Task>(this.taskList);
			Collections.sort(sortedList);
			Task task = sortedList.get(0);
			task.execute();
			this.taskList.remove(task);
		}
	}

}