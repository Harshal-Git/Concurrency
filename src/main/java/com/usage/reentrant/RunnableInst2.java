/**
 * 
 */
package com.usage.reentrant;

/**
 * @author Harshal-Git
 *
 */
public class RunnableInst2 implements Runnable {

	private Display2 dispParam;
	private String nameParam;
	
	/**
	 * parameterized constructor 
	 */
	public RunnableInst2(Display2 disp, String name) {
		this.dispParam = disp;
		this.nameParam = name;
	}
	
	@Override
	public void run() {
		this.dispParam.wish(this.nameParam);
	}

	
}
