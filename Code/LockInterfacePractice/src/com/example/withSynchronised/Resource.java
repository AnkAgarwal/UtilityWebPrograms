package com.example.withSynchronised;

public class Resource {

	/**
	 * @param args
	 */
	public void doSomething(){
		System.out.println(Thread.currentThread().getName()+" is doing something");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" has done something");
	}
	
	public void doLogging(){
		System.out.println(Thread.currentThread().getName()+" is doing logging");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" has done logging");
		
	}

}
