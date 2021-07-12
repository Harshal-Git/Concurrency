/**
 * 
 */
package com.usage.tryLock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harshal-Git
 *
 *	-> Display object using ReentrantLock.tryLock() method
 */
public class MyRunnable implements Runnable {

	// only one lock is expected
	private static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		// get current thread name
		String threadName = Thread.currentThread().getName();

		// try to query lock
		if(lock.tryLock()) {
			System.out.println(threadName+" acquired the lock and performing action...");
			try {
				System.out.println(threadName+" sleeping...");
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println(threadName+" got interrupted.");
			}
			// release lock
			lock.unlock();
			System.out.println(threadName+" released lock.");
		} else {
			// if thread could not acquired lock : perform alternate operations
			System.out.println(threadName+" was unable to acquire lock and performing alternate actions...");
		}		
	}
}