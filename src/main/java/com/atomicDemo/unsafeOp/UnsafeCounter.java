/**
 * 
 */
package com.atomicDemo.unsafeOp;

/**
 * @author Harshal-Git
 *
 */
public class UnsafeCounter {

	private int MAX_RANGE;
	private volatile int counter = 0;

	/**
	 * param constructor 
	 */
	public UnsafeCounter(int maxLimit) {
		this.MAX_RANGE = maxLimit;
	}
	
	public int getCounter() {
		return counter;
	}
	
	//public synchronized void incrementCounter() {
	public void incrementCounter() {
		for(int i = 1; i <= MAX_RANGE; i++) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				System.out.println("Thread sleep interrupted.");
			}
			counter++;
		}
	}
}
