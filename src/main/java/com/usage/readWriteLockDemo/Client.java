/**
 * 
 */
package com.usage.readWriteLockDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Harshal-Git
 *
 *	-> 2 threads trying to insert even / odd numbers in a shared list and a reader thread is trying to access the list to 
 *		read the data.
 *
 * 	-> As both threads are expected to write the data first; they will write lock the list to add the data and release the locks. 
 * 		Meanwhile reader thread will keep trying to get hold of read lock. Once there is no more read lock applied; reader thread
 * 		will finally start reading the data.
 * 
 *  -> using read/write thread; we can make a non-synchronized collection object to behave in a synchronized manner. 
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// prepare a lock object
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		
		// prepare empty data list
		List<Integer> dataList = new ArrayList<>();
		
		// prepare even number writer object
		EvenWriterRunnable wr1 = new EvenWriterRunnable(dataList, lock);
		
		// prepare odd number writer object
		OddWriterRunnable wr2 = new OddWriterRunnable(dataList, lock);
		
		// prepare reader object
		ReaderRunnable rr = new ReaderRunnable(dataList, lock);
		
		// prepare thread objects
		Thread tw1 = new Thread(wr1, "Even writer");
		Thread tw2 = new Thread(wr2, "Odd writer");
		Thread tw3 = new Thread(rr, "Reader");
		
		// start & join threads
		tw1.start();
		tw2.start();
		tw3.start();
		
		// join all threads
		try {
			tw1.join();
			tw2.join();
			tw3.join();
		} catch (InterruptedException e) {
			System.out.println("Thread join interrupted.");
		}
	}
}
