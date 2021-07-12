/**
 * 
 */
package com.usage.reentrant;

/**
 * @author Harshal-Git
 *
 *	-> Using Reentrant lock in-place of synchronized keyword : between 2 threads sharing common "Display2" object.
 */
public class Client2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare shared object
		Display2 disp = new Display2();
		
		// prepare thread 1
		RunnableInst2 runnable1 = new RunnableInst2(disp, "P1");
		Thread t1 = new Thread(runnable1);
		
		// prepare thread 2
		RunnableInst2 runnable2 = new RunnableInst2(disp, "P2");
		Thread t2 = new Thread(runnable2);

		// prepare thread 3
		RunnableInst2 runnable3 = new RunnableInst2(disp, "P3");
		Thread t3 = new Thread(runnable3);
		
		// start both threads
		t1.start();
		t2.start();
		t3.start();
	}

}
