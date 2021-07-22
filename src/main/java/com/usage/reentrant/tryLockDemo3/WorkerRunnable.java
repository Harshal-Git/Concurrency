/**
 * 
 */
package com.usage.reentrant.tryLockDemo3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harshal-Git
 *
 *	-> a runnable worker class which will implement Runnable interface 
 *
 *	-> every thread will try to acquire lock twice & then will release it in reverse order.
 *
 *	-> other thread/s will wait until both locks are released.
 */
public class WorkerRunnable implements Runnable {

	private String workerName = null;

	private ReentrantLock lock = null;

	/**
	 * param constructor 
	 */
	public WorkerRunnable(ReentrantLock lockObj, String name) {
		this.workerName = name;
		this.lock = lockObj;
	}

	private String getThreadName() {
		return this.workerName;
	}

	private ReentrantLock getLockObj() {
		return this.lock;
	}

	@Override
	public void run() {
		boolean isDone = false;
		while(!isDone) {

			// try first lock
			boolean hasLock = getLockObj().tryLock();
			if(hasLock) {

				// if any thread is able to acquire lock first
				System.out.println(getThreadName()+" has acquired first lock...will sleep now.");

				// sleep after first lock & acquire second lock
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(getThreadName()+" interrupted during sleep.");	
				} finally {
					// try to acquire second lock
					System.out.println(getThreadName()+" acquiring second lock...will sleep now.");
					getLockObj().lock();
				}

				// check current lock count
				//System.out.println("Current lock hold count by "+getThreadName()+" = "+getLockObj().getHoldCount());

				// sleep & release lock now (in reverse order it's obtained)
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(getThreadName()+" interrupted during sleep.");	
				} finally {
					System.out.println(getThreadName()+" will release second lock now.");
					getLockObj().unlock();	
				}

				// check current lock status
				//System.out.println("Current lock hold count by "+getThreadName()+" = "+getLockObj().getHoldCount());

				// release lock (in reverse order it's obtained)
				System.out.println(getThreadName()+" will release first lock now.");
				getLockObj().unlock();
				//System.out.println("Current lock hold count by "+getThreadName()+" = "+getLockObj().getHoldCount());
				System.out.println(getThreadName()+" has been finished.");
				isDone = true;
			} else {
				// if a thread is not successful to acquire a lock: it will do something else
				System.out.println(getThreadName()+" will try to acquire first lock again...");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					System.out.println(getThreadName()+" interrupted during sleep.");	
				}
			}
		}
	}
}
