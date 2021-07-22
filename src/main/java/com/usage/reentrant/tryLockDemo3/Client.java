/**
 * 
 */
package com.usage.reentrant.tryLockDemo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harshal-Git
 *
 */
public class Client {

	private static final int MAX_THREAD = 3; 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare a common Reentrant thread
		ReentrantLock rLock = new ReentrantLock();
		
		// prepare executor service batch
		ExecutorService batch = Executors.newFixedThreadPool(MAX_THREAD);
		
		// prepare runnable instances
		WorkerRunnable wr1 = new WorkerRunnable(rLock, "W1");
		WorkerRunnable wr2 = new WorkerRunnable(rLock, "W2");
		WorkerRunnable wr3 = new WorkerRunnable(rLock, "W3");
		WorkerRunnable wr4 = new WorkerRunnable(rLock, "W4");
		
		// submit instances to batch
		batch.execute(wr1);
		batch.execute(wr2);
		batch.execute(wr3);
		batch.execute(wr4);
		
		// shutdown service
		batch.shutdown();
	}
}
