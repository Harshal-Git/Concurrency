/**
 * 
 */
package com.usage.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harshal-Git
 *
 *	-> Display object using Reentrant lock
 */
public class Display2 {

	private ReentrantLock lock = new ReentrantLock();
	
	/**
	 * @param name
	 */
	public void wish(String name) {
		
		// running thread will acquire lock for this object
		lock.lock();
		
		for(int i = 1; i <= 5; i++) {
			System.out.print("Good morning: ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("sleeping() thread interrupted.");
			}
			System.out.println(name);
		}
		System.out.println();
		
		// once execution gets over; running thread will release lock
		lock.unlock();
	}
}
