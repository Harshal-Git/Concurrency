/**
 * 
 */
package com.usage.reentrant.tryLockDemo1;

/**
 * @author Harshal-Git
 *
 *	-> 2 threads trying to ask for lock OR choosing alternate option.
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
