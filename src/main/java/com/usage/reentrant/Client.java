/**
 * 
 */
package com.usage.reentrant;

/**
 * @author Harshal-Git
 *
 *	-> Using Reentrant lock in-place of synchronized keyword : between 2 threads sharing common "Display" object.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare shared object
		Display disp = new Display();
		
		// prepare thread 1
		RunnableInst runnable1 = new RunnableInst(disp, "P1");
		Thread t1 = new Thread(runnable1);
		
		// prepare thread 2
		RunnableInst runnable2 = new RunnableInst(disp, "P2");
		Thread t2 = new Thread(runnable2);

		// prepare thread 3
		RunnableInst runnable3 = new RunnableInst(disp, "P3");
		Thread t3 = new Thread(runnable3);
		
		// start both threads
		t1.start();
		t2.start();
		t3.start();
	}

}
