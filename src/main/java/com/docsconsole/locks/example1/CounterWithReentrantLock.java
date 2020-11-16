package com.docsconsole.locks.example1;

import java.util.concurrent.locks.ReentrantLock;

public class CounterWithReentrantLock {
	
	private final ReentrantLock lock = new ReentrantLock();
	private int counter = 0;
	
	public int getCount() {
		lock.lock();
		try {
			String currentThreadName = Thread.currentThread().getName();
			System.out.println("Current Thread"+ currentThreadName + " counter: " + counter);
			return counter ++;
		} finally {
			lock.unlock();
		}

	}
	
	public static void main(String args[]) {
		
	       final CounterWithReentrantLock counter = new CounterWithReentrantLock();
	       Thread t1 = new Thread() {

	           @Override
	           public void run() {
	               while (counter.getCount() < 6) {
	                   try {
	                       Thread.sleep(100);
	                   } catch (InterruptedException ex) {
	                       ex.printStackTrace();                    }
	               }
	           }
	       };
	     
	       Thread t2 = new Thread() {

	           @Override
	           public void run() {
	               while (counter.getCount() < 6) {
	                   try {
	                       Thread.sleep(100);
	                   } catch (InterruptedException ex) {
	                       ex.printStackTrace();
	                   }
	               }
	           }
	       };
	     
	       t1.start();
	       t2.start();
	     
	   }
}
