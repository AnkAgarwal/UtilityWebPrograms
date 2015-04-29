package com.ion.main;

import java.util.ArrayList;
import java.util.List;

import com.ion.task.Task;
import com.ion.taskscheduler.TaskScheduler;

public class Main_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Case 1: Normal behaviour where task with different priority are
		// populated in the TaskScheduler
		// Populate task list
		int id = 10;
		List<Task> taskList = new ArrayList<Task>();
		for (int i = 10; i > 0; i--) {
			Task task = new Task(id, "Task" + id, id);
			taskList.add(task);
			id--;
		}

		// Create object of TaskScheduler and call executeAll and
		// executeAllByPriority method to execute task
		TaskScheduler schedule = new TaskScheduler(taskList);
		// schedule.executeAll();
		System.out.println("------------------");
		schedule.executeAllByPriority();
		System.out.println(taskList.size());

	}

}
