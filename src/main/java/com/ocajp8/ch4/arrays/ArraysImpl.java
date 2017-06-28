/**
 * 
 */
package com.ocajp8.ch4.arrays;

/**
 * @author Yashwanth
 *
 */
public class ArraysImpl {

	static String objArray[] = new String[]{"Yash","KR","Banda"};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printString(objArray);
	}

	public static void printString(String[] arrayStr){
		for(Object obj:arrayStr){
			System.out.println(obj.toString());
		}
	}
}
