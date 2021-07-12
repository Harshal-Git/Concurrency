/**
 * 
 */
package com.usage.synch;

/**
 * @author Harshal-Git
 *
 *	-> standard way a synchronization is done between 2 threads sharing common "MyRunnable" object.
 */
public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare shared object
		Display1 disp = new Display1();
		
		// prepare thread 1
		RunnableInst1 runnable1 = new RunnableInst1(disp, "P1");
		Thread t1 = new Thread(runnable1);
		
		// prepare thread 2
		RunnableInst1 runnable2 = new RunnableInst1(disp, "P2");
		Thread t2 = new Thread(runnable2);
		
		// start both threads
		t1.start();
		t2.start();
	}

}
