package com.example.test;

public class Use{  
	public static void main(String args[]){  
	Table obj = new Table();//only one object  
	MyThread1 t1=new MyThread1(obj);  
	MyThread1 t2=new MyThread1(obj);  
	t1.start();  
	t2.start();  
	}  
} 
