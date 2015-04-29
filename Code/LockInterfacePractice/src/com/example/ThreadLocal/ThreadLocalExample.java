package com.example.ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {
	
	 private static final ThreadLocal<Integer> formatter = new ThreadLocal<Integer>(){
		 protected Integer initialValue() {
			 return new Integer(2);
		 }
	 };
	       
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread Name= "+Thread.currentThread().getName()+" initial value is "+formatter.get());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        formatter.set(new Integer(5));
         
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" final value is "+formatter.get());
   

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ThreadLocalExample obj = new ThreadLocalExample();
	        for(int i=0 ; i<10; i++){
	            Thread t = new Thread(obj, ""+i);
	            try {
					Thread.sleep(new Random().nextInt(1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            t.start();
	        }

	}

}
