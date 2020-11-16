package com.docsconsole.locks.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample implements Runnable{
	
	private final ReentrantLock lock = new ReentrantLock();
	private SharableCounter sharableCounter;
	
	
	public ReentrantLockExample(SharableCounter sharableCounter) {	
		this.sharableCounter = sharableCounter;
	}


	@Override
	public void run() {
		try {
			if(lock.tryLock(10, TimeUnit.SECONDS)){
				sharableCounter.incrementCount();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//release lock
			lock.unlock();
		}
		sharableCounter.getCount();
		
	}
	
	
}
