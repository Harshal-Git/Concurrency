/**
 * 
 */
package com.atomicDemo.unsafeOp;

/**
 * @author Harshal-Git
 *
 */
public class Runnable1 implements Runnable{

	private UnsafeCounter counter = null;
	
	/**
	 * param constructor
	 */
	public Runnable1(UnsafeCounter ctr) {
		this.counter = ctr;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" thread started counting...");
		counter.incrementCounter();
	}
}
