package com.example.withSynchronised;

public class SynchronizedLockExample implements Runnable {
	
	private Resource resource;
	
	public SynchronizedLockExample(Resource r){
		this.resource=r;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource res=new Resource();
		SynchronizedLockExample obj1=new SynchronizedLockExample(res);
		SynchronizedLockExample obj2=new SynchronizedLockExample(res);
		SynchronizedLockExample obj3=new SynchronizedLockExample(res);
		
		Thread t1=new Thread(obj1, "Thread1");
		Thread t2=new Thread(obj2, "Thread2");
		Thread t3=new Thread(obj3, "Thread3");
		t1.start();
		t2.start();
		t3.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (resource) {
			resource.doSomething();
		}
		resource.doLogging();
	}

}
