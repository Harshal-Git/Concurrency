/**
 * 
 */
package com.liveLockDemo;

/**
 * @author Harshal-Git
 *
 *	-> An example of live lock. 
 *
 *	-> A cop waiting for criminal to release the hostage & criminal waiting for cop to provide ransome. They both keep
 *		waiting for each other doing the same process.
 *
 *	-> As compared to Deadlock; Livelock will not halt the thread execution. Threads will be on-going continously without 
 *		coming to any stop.
 *
 * 	-> While in deadlock; thread will not do anything but waiting.
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare objects
		final Cop cop = new Cop();
		final Criminal criminal = new Criminal();

		// prepare runnable instances
		Runnable runnableCop = new Runnable() {
			@Override
			public void run() {
				cop.giveRansom(criminal);
			}
		};

		Runnable runnableCriminal = new Runnable() {
			@Override
			public void run() {
				criminal.leaveHostage(cop);
			}
		};

		// start threads
		Thread t1 = new Thread(runnableCriminal, "Criminal");
		Thread t2 = new Thread(runnableCop, "Cop");
		t1.start();
		t2.start();
	}

}
