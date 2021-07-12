/**
 * 
 */
package com.usage.tryLock2;

/**
 * @author Harshal-Git
 *
 *	-> 2 threads trying to ask for lock continuously until both finishes their respective execution.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// thread 1
		MyRunnable r1 = new MyRunnable();
		Thread t1 = new Thread(r1, "T1");
		
		// thread 2
		MyRunnable r2 = new MyRunnable();
		Thread t2 = new Thread(r2, "T2");
		
		// start both threads
		t1.start();
		t2.start();
	}

}
