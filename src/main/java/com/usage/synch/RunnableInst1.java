/**
 * 
 */
package com.usage.synch;

/**
 * @author Harshal-Git
 *
 */
public class RunnableInst1 implements Runnable {

	private Display1 dispParam;
	private String nameParam;
	
	/**
	 * parameterized constructor 
	 */
	public RunnableInst1(Display1 disp, String name) {
		this.dispParam = disp;
		this.nameParam = name;
	}
	
	@Override
	public void run() {
		this.dispParam.wish(this.nameParam);
	}

	
}
