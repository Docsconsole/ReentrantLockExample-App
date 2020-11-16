package com.docsconsole.locks.example;

public class TestLockExamples {
	public static void main(String[] args) {

		SharableCounter sharableCounter = new SharableCounter();

		ReentrantLockExample rLock = new ReentrantLockExample(sharableCounter);
		Thread thread = new Thread(rLock, "ReentrantLock");
		thread.start();

		SynchronizedLockExample sLock = new SynchronizedLockExample(sharableCounter);
		Thread thread1 = new Thread(sLock, "SynchronizedLock");
		thread1.start();

	}

}
