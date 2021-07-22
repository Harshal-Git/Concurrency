/**
 * 
 */
package com.atomicDemo.safeOp;

/**
 * @author Harshal-Git
 *
 *	2 threads; working on the same counter object; are expected to update the counter with double of it's value.
 *
 *	Means if both threads are working on the same counter which is expected to be atomic; ideally 'counter' should be 
 *	2,00,000 fixed result (double the value passed in parameter). 
 *
 *	Using AtomicInteger; expected results can be obtained without much of a context switching & any synchronization. And using
 *	Atomic objects; we can get better performance compared to "synchronization" method.   
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare counter object
		int counterVal = 100000;
		SafeCounterWithLock counterObj = new SafeCounterWithLock(counterVal);
		
		// prepare runnable instances 
		Runnable2 run1 = new Runnable2(counterObj);
		Runnable2 run2 = new Runnable2(counterObj);
		
		// prepare threads
		Thread t1 = new Thread(run1, "T1");
		Thread t2 = new Thread(run2, "T2");
		
		// start time
		long startTime = System.currentTimeMillis();
		
		// start threads
		t1.start();
		t2.start();
		
		// join both
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.out.println("join() interrupted."+e.getMessage());
		}
		// end time
		long endTime = System.currentTimeMillis();
		// print count
		System.out.println("Final count: "+counterObj.getCounter());
		System.out.println("Total time taken: "+((endTime-startTime))+" ms.");
	}
}
