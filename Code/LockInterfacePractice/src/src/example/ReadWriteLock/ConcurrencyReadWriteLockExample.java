package src.example.ReadWriteLock;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.example.withSynchronised.Resource;

public class ConcurrencyReadWriteLockExample implements Runnable{
	
	private HashMap<String, String> myMap;
	private ReadWriteLock rwl;
	private Lock readLock;
	private Lock writeLock;
	//private WriteLock writeLock;
	
	/*public ConcurrencyReadWriteLockExample(HashMap myMap, ReadWriteLock readWriteLock,Lock readLock,Lock writeLock){
		this.myMap=myMap;
		this.rwl=readWriteLock;
		this.readLock=readLock;
		this.writeLock=writeLock;
	}*/

	public ConcurrencyReadWriteLockExample(HashMap myMap, ReadWriteLock readWriteLock){
		this.myMap=myMap;
		this.rwl=readWriteLock;
		
	}
	
	public void put(String key,String value){
		rwl.writeLock().lock();
		try{
			myMap.put(key, value);
		}finally{
			rwl.writeLock().unlock();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Resource res=new Resource();
		HashMap<String, String> myMap=new HashMap<String, String>();
		ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
		Lock readLock=readWriteLock.readLock() ;
		Lock writeLock=readWriteLock.writeLock() ;
		
		/*ConcurrencyReadWriteLockExample obj1=new ConcurrencyReadWriteLockExample(myMap,readWriteLock,readLock,writeLock);
		ConcurrencyReadWriteLockExample obj2=new ConcurrencyReadWriteLockExample(myMap,readWriteLock,readLock,writeLock);
		ConcurrencyReadWriteLockExample obj3=new ConcurrencyReadWriteLockExample(myMap,readWriteLock,readLock,writeLock);*/
		
		ConcurrencyReadWriteLockExample obj1=new ConcurrencyReadWriteLockExample(myMap,readWriteLock);
		ConcurrencyReadWriteLockExample obj2=new ConcurrencyReadWriteLockExample(myMap,readWriteLock);
		ConcurrencyReadWriteLockExample obj3=new ConcurrencyReadWriteLockExample(myMap,readWriteLock);
		
		Thread t1=new Thread(obj1, "Thread1");
		Thread t2=new Thread(obj2, "Thread2");
		Thread t3=new Thread(obj3, "Thread3");
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(myMap);

	}

	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		
			if(lock.tryLock()){
				try {
					res.doSomething();
				}finally{
					lock.unlock();
				}
			}
		
		res.doLogging();
		
	}*/
	
	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		
			try {
				if(lock.tryLock(2, TimeUnit.SECONDS)){
					try {
						res.doSomething();
					}finally{
					
						lock.unlock();
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		res.doLogging();
		
	}*/
	
	@Override
	public void run() {
		
		myMap.put(Thread.currentThread().getName(),"Agarwal");
		
	}

}
