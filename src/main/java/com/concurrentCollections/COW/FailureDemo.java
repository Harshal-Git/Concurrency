/**
 * 
 */
package com.concurrentCollections.COW;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Harshal-Git
 *
 *	-> program to show case concurrent modification exception on an array list
 */
public class FailureDemo {

	// using normal collection; it will cause concurrent modification exception 
	public static List<Integer> al = new ArrayList<>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// main thread performing adding data in collection
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		
		// main thread starting child thread 
		MyThread2 t1 = new MyThread2();
		t1.start();
		
		// meanwhile main thread iterating collection
		ListIterator<Integer> lItr = al.listIterator();
		Integer itrData = null;
		while(lItr.hasNext()) {
			itrData = lItr.next();
			if(itrData != null) {
				System.out.println("Main thread read: "+itrData.intValue());
			}
			try {
				System.out.println("Main thread will sleep now.");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Main thread sleeping interrupted.");
			}
		}
		System.out.println("Final list: "+al.toString());
	}
}

// child thread performing modification to the collection
class MyThread2 extends Thread {
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Running Child thread "+threadName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread "+threadName+" got interrupted.");
		}
		System.out.println("Child thread "+threadName+" adding 99 to collection...");
		FailureDemo.al.add(99);
	}
	
}