/**
 * 
 */
package com.methodDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harshal-Git
 *
 */
public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ReentrantLock lock1 = new ReentrantLock();
		lock1.lock();	// line executed by main thread which will acquire lock
		lock1.lock();	
		
		// whether object is locked?
		System.out.println("Is locked? "+lock1.isLocked());
		
		// whether current thread holds the lock?
		System.out.println("Is lock held by current thread? "+lock1.isHeldByCurrentThread());
		
		// get number of holds for current object
		System.out.println("Number of holds? "+lock1.getHoldCount());
		
		// release lock
		lock1.unlock();
		System.out.println("unlock() called.");
		
		System.out.println("Number of holds? "+lock1.getHoldCount());
		
		System.out.println("Is locked? "+lock1.isLocked());
		
		// release lock
		lock1.unlock();
		System.out.println("unlock() called.");
		
		System.out.println("Number of holds? "+lock1.getHoldCount());
		
		System.out.println("Is locked? "+lock1.isLocked());
	}

}
