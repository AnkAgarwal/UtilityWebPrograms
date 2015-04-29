package src.example.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.example.withSynchronised.Resource;

public class ConcurrencyLockExample implements Runnable{
	
	private Resource res;
	private Lock lock;
	Condition myCondition;
	
	public ConcurrencyLockExample(Resource r, Lock lock){
		this.res=r;
		this.lock=lock;
		myCondition=this.lock.newCondition();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource res=new Resource();
		Lock lock=new ReentrantLock();
		ConcurrencyLockExample obj1=new ConcurrencyLockExample(res,lock);
		ConcurrencyLockExample obj2=new ConcurrencyLockExample(res,lock);
		ConcurrencyLockExample obj3=new ConcurrencyLockExample(res,lock);
		
		Thread t1=new Thread(obj1, "Thread1");
		Thread t2=new Thread(obj2, "Thread2");
		Thread t3=new Thread(obj3, "Thread3");
		t1.start();
		t2.start();
		t3.start();

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
		// TODO Auto-generated method stub
		
		lock.lock();
		/*if(true){
			try {
				//Current thread is in waiting pool and waits unless signal or signalAll method is called on this condition
				//myCondition.signalAll();				
				myCondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		res.doSomething();
		lock.unlock();
		res.doLogging();
		
		
		
	}

}
