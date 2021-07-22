/**
 * 
 */
package com.usage.readWriteLockDemo;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Harshal-Git
 *
 */
public class ReaderRunnable implements Runnable {

	private List<Integer> dataList = null;

	private ReentrantReadWriteLock reentrantLock = null;

	public List<Integer> getList() {
		return this.dataList;
	}

	public ReentrantReadWriteLock getLock() {
		return this.reentrantLock;
	}

	/**
	 * param constructor 
	 */
	public ReaderRunnable(List<Integer> data, ReentrantReadWriteLock lockObj) {
		this.dataList = data;
		this.reentrantLock = lockObj;
	}

	@Override
	public void run() {
		// start read process
		while(true) {
			// just to pause for a while before attempting to read again
			try {
				Thread.sleep(700);			
			} catch (InterruptedException e) {
				System.out.println("Reader thread sleep() interrupted.");
			}
			// check whether write lock is present: if not then pause for a while
			if(getLock().isWriteLocked()) {
				System.out.println("list is writeLocked...will check again in a moment...");
				try {
					Thread.sleep(1000);			
				} catch (InterruptedException e) {
					System.out.println("Reader thread sleep() interrupted.");
				}
				
			} else {

				// acquire read lock
				getLock().readLock().lock();
				System.out.println(Thread.currentThread().getName()+" has acquired read lock.");

				// read & print data
				System.out.print(Thread.currentThread().getName()+" is reading data => ");
				for(int elem : getList()) {
					System.out.print(elem+" ");
				}
				
				// release lock
				getLock().readLock().unlock();
				System.out.println("\n"+Thread.currentThread().getName()+" has released read lock.");
				break;
			}
		}
	}
}
