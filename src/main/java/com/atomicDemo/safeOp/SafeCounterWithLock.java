/**
 * 
 */
package com.atomicDemo.safeOp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Harshal-Git
 *
 */
public class SafeCounterWithLock {

	private final AtomicInteger counter = new AtomicInteger(0);
	
	private int MAX_LIMIT;
	
	/**
	 * param constructor 
	 */
	public SafeCounterWithLock(int maxVal) {
		this.MAX_LIMIT = maxVal;
	}
	
	public int getCounter() {
		return counter.intValue();	// same as counter.get()
	}
	
	public void incrementCounter() {
		for(int i = 1; i <= MAX_LIMIT; i++) {
			counter.incrementAndGet();
		}
	}
}
