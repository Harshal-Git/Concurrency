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
public class OddWriterRunnable implements Runnable {

	private List<Integer> dataList = null;

	private ReentrantReadWriteLock reentrantLock = null;

	/**
	 * param constructor 
	 */
	public OddWriterRunnable(List<Integer> data, ReentrantReadWriteLock lockObj) {
		this.dataList = data;
		this.reentrantLock = lockObj;
	}

	public List<Integer> getList() {
		return this.dataList;
	}

	public ReentrantReadWriteLock getLock() {
		return this.reentrantLock;
	}

	@Override
	public void run() {
		// acquire write lock
		getLock().writeLock().lock();
		System.out.println(Thread.currentThread().getName()+" has acquired write lock.");

		// write data
		for(int i = 1; i <= 10; i++) {
			if(i % 2 != 0) {
				getList().add(i);
				System.out.println(Thread.currentThread().getName()+" has added "+i);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" interrupted.");
			}
		}

		// release lock
		getLock().writeLock().unlock();
		System.out.println(Thread.currentThread().getName()+" has released write lock.");

	}

}
