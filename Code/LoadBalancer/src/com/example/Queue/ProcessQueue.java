package com.example.Queue;

import java.util.ArrayList;

public class ProcessQueue {
	
	//8457575517
	public ArrayList<String> queue;
	//public String message;
	//public static int[] completeArr = null;
	//public static int[] startArr = null;
	
	public ProcessQueue(){ 
		this.queue=new ArrayList<String>();
		//message="";
    } 
	
	public ProcessQueue(int numThread){ 
		this.queue=new ArrayList<String>();
    } 
	
	
	public void addItem(String item){
		this.queue.add(item);
	}
	
	public String getItem(int index){
		return this.queue.get(index);
	}
	
	public String removeItem(int index){
		if (this.queue.size()>0)
			return this.queue.remove(index);
		else
			return null;
	}
	
	public void deleteItem(int index){
		this.queue.remove(index);
	}
	
	public boolean isEmpty(){
		return this.queue.isEmpty();
	}
	
	public int getSize(){
		return this.queue.size();
	}

	
}
