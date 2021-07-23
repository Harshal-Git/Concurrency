/**
 * 
 */
package com.usage.reentrant.tryLockDemo2;

/**
 * @author Harshal-Git
 *
 *	-> 2 threads trying to ask for lock repeatedly until both finishes their respective execution.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare a runnable instance
		MyRunnable runnable = new MyRunnable();
		
		// thread 1
		Thread t1 = new Thread(runnable, "T1");
		
		// thread 2
		Thread t2 = new Thread(runnable, "T2");
		
		// start both threads
		t1.start();
		t2.start();
	}

}
