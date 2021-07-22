/**
 * 
 */
package com.liveLockDemo;

/**
 * @author Harshal-Git
 *
 */
public class Criminal {

	private boolean hasLeftHostage = false;

	public boolean hasLeftHostage() {
		return this.hasLeftHostage ;
	}

	private void setLeftHostage(boolean val) {
		this.hasLeftHostage = val;
	}

	public void leaveHostage(Cop copObj) {
		while(true) {
			if(!copObj.hasMoneySent()) {
				System.out.println(Thread.currentThread().getName()+" waiting for Cop to send ransom...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" got interrupted.");
				}
			} else {
				System.out.println(Thread.currentThread().getName()+" will leave the hostages.");
				setLeftHostage(true);
				break;
			}
		}
	}
}
