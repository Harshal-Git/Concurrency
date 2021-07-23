/**
 * 
 */
package com.usage.reentrant.tryLockDemo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harshal-Git
 *
 *	-> thread using tryLock() to ask for lock until it receives one.
 *
 * 	-> it shows how alternate option can also be utilized to ask for lock again.
 */
public class MyRunnable implements Runnable {

	// only one lock is expected
	private static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		// get current thread name
		String threadName = Thread.currentThread().getName();

		// keep trying for both threads to acquire lock
		while(true){
			try {
				// try to acquire lock every 5 seconds
				if(lock.tryLock(5000, TimeUnit.MILLISECONDS)) {
					System.out.println(threadName+" acquired the lock and performing action...");
					try {
						System.out.println(threadName+" sleeping...");
						Thread.sleep(12000);
					} catch (InterruptedException e) {
						System.out.println(threadName+" got interrupted.");
					}
					// release lock
					lock.unlock();
					System.out.println(threadName+" released lock.");
					// once thread releases lock; then break the do-while loop for current thread
					break;	
				} else {
					// if thread could not acquired lock : perform alternate operations
					System.out.println(threadName+" was unable to acquire lock so it will try again...");
				}
			} catch (InterruptedException e) {
				System.out.println(threadName+" was interrupted while acquiring lock.");
			}
		}
	}
}