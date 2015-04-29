package com.ion.task;

public class Task implements Comparable<Task> {

	private int priority;
	private String name;
	private int id;

	public Task(int id, String name, int priority) {
		this.id = id;
		this.name = name;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void execute() {
		System.out.println(this.name + " is getting executed with the id "
				+ this.id + " and priority " + this.priority);
	}

	//Overide comaprable method to sort on the basis of priority
	@Override
	public int compareTo(Task comparePriority) {
		// TODO Auto-generated method stub
		int priority = (int) comparePriority.getPriority();
		// for ascending order
		return this.priority - priority;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if (arg0 == null)
			return false;

		if (arg0 instanceof Task) {
			Task obj = (Task) arg0;

			if (this.id == obj.id && this.name == obj.name
					&& this.priority == obj.priority)
				return true;
		}
		return false;
	}

}
