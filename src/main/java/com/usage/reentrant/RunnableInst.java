/**
 * 
 */
package com.usage.reentrant;

/**
 * @author Harshal-Git
 *
 */
public class RunnableInst implements Runnable {

	private Display dispParam;
	private String nameParam;
	
	/**
	 * parameterized constructor 
	 */
	public RunnableInst(Display disp, String name) {
		this.dispParam = disp;
		this.nameParam = name;
	}
	
	@Override
	public void run() {
		this.dispParam.wish(this.nameParam);
	}

	
}
