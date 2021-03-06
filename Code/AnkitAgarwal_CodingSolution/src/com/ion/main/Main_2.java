package com.ion.main;

import java.util.ArrayList;
import java.util.List;

import com.ion.task.Task;
import com.ion.taskscheduler.TaskScheduler;

public class Main_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Case 2: No task added in the task list
		// Populate task list

		List<Task> taskList = new ArrayList<Task>();

		// Create object of TaskScheduler and call executeAll and
		// executeAllByPriority method to execute task
		TaskScheduler schedule = new TaskScheduler(taskList);
		schedule.executeAll();
		System.out.println("------------------");
		schedule.executeAllByPriority();

	}

}
