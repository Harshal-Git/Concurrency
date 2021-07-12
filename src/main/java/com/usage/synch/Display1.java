/**
 * 
 */
package com.usage.synch;

/**
 * @author Harshal-Git
 *
 *	-> Display object using synchronized method
 */
public class Display1 {

	/**
	 * @param name
	 */
	public synchronized void wish(String name) {
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
	}
}
