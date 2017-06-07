/**
 * 
 */
package com.ocajp8.ch3.methodnEncaps;

/**
 * @author Yashwanth
 *
 */
public class Variables {

	/**
	 * @param args
	 */
	
	private int instanceVar1 =1,instanceVar2=2;
	public static void main(String[] args) {

		
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSum(){
		int localSum=0;
		localSum = instanceVar1+instanceVar2;
		return localSum;
	}
	

}
