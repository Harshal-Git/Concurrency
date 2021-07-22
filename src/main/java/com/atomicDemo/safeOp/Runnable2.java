/**
 * 
 */
package com.atomicDemo.safeOp;

/**
 * @author Harshal-Git
 *
 */
public class Runnable2 implements Runnable{

	private SafeCounterWithLock counter = null;
	
	/**
	 * param constructor
	 */
	public Runnable2(SafeCounterWithLock ctr) {
		this.counter = ctr;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" thread started counting...");
		counter.incrementCounter();
	}
}
