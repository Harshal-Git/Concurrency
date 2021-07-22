/**
 * 
 */
package com.liveLockDemo;

/**
 * @author Harshal-Git
 *
 */
public class Cop {

	private boolean hasMoneySent = false;

	public boolean hasMoneySent() {
		return this.hasMoneySent;
	}

	private void setHasSentMoney(boolean val) {
		this.hasMoneySent = val;
	}

	public void giveRansom(Criminal criminal) {
		while(true) {
			if(!criminal.hasLeftHostage()) {
				System.out.println(Thread.currentThread().getName()+" waiting for Criminal to leave hostages...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()+" got interrupted.");
				}
			} else {
				System.out.println(Thread.currentThread().getName()+" will pay the ransome.");
				setHasSentMoney(true);
				break;
			}
		}
	}
}
