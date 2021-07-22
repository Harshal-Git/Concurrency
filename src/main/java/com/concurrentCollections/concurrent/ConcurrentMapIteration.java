/**
 * 
 */
package com.concurrentCollections.concurrent;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Harshal-Git
 *
 *	-> program to show case concurrent modification exception can be avoided with concurrent hashmap. If normal hashmap is used; 
 *		then concurrent modification exception will be thrown.
 */
public class ConcurrentMapIteration {

	// using concurrent hashmap 
	public static Map<Integer, String> cMap = new ConcurrentHashMap<>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// main thread performing adding data in collection
		cMap.put(101, "hello");
		cMap.put(103, "there");
		cMap.put(105, "java");
		cMap.put(107, "world");
		
		// main thread starting child thread 
		MyThread1 t1 = new MyThread1();
		t1.start();
		
		// meanwhile main thread iterating map key collection
		Iterator<Integer> mKeyItr = cMap.keySet().iterator();
		Integer itrKey = null;
		while(mKeyItr.hasNext()) {
			itrKey = mKeyItr.next();
			if(itrKey != null) {
				System.out.println("Main thread read key = "+itrKey.intValue()+ " & value = "+cMap.get(itrKey.intValue()));
			}
			try {
				System.out.println("Main thread will sleep now.");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Main thread sleeping interrupted.");
			}
		}
		System.out.println("Final map: "+cMap.toString());
	}
}

// child thread performing modification to the collection
class MyThread1 extends Thread {
	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Running Child thread "+threadName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread "+threadName+" got interrupted.");
		}
		System.out.println("Child thread "+threadName+" adding more value to map...");
		ConcurrentMapIteration.cMap.put(109, "this is");
	}
	
}