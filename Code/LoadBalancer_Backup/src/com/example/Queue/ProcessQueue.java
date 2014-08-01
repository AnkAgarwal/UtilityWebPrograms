package com.example.Queue;

import java.util.ArrayList;

public class ProcessQueue {

	private ArrayList<String> queue;
	public static int[] completeArr = null;
	public static int[] startArr = null;
	
	public ProcessQueue(){ 
		this.queue=new ArrayList<String>();
		completeArr=new int[3];
		startArr=new int[3];
    } 
	
	public ProcessQueue(int numThread){ 
		this.queue=new ArrayList<String>();
		completeArr=new int[numThread];
		startArr=new int[numThread];
    } 
	
	
	public void addItem(String item){
		this.queue.add(item);
	}
	
	public String getItem(int index){
		return this.queue.get(index);
	}
	
	public String removeItem(int index){
		return this.queue.remove(index);
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
