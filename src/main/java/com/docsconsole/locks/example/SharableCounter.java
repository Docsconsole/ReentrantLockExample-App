package com.docsconsole.locks.example;

public class SharableCounter {

	private int counter = 0;
	
	public int getCount() {

		String currentThreadName = Thread.currentThread().getName();
		System.out.println("Current Thread  " + currentThreadName + " counter: " + counter);
		return counter;

	}

	public int incrementCount() {
		 
		while (this.getCount() < 6) {
			counter++;			
		}
		return counter;
	}

}
