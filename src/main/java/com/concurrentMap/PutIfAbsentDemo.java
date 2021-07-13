/**
 * 
 */
package com.concurrentMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Harshal-Git
 *
 *	-> comparison between put() & putIfAbsent()
 */
public class PutIfAbsentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// hashmap
		Map<Integer, String> m1 = new HashMap<>();
		
		// put method of map overrides value : if it is already present
		m1.put(1, "hello");
		m1.put(1, "there");
		System.out.println("Hashmap: "+m1.toString());
		
		// concurrent hashmap
		Map<Integer, String> m2 = new ConcurrentHashMap<>();
		
		// putIfAbsent() will insert value only if key is not present
		m2.putIfAbsent(1, "hello");
		m2.putIfAbsent(1, "there");
		System.out.println("Concurrent Hashmap: "+m2.toString());
	}

}
