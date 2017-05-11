/**
 * 
 */
package com.ocajp8.ch1.basics;

/**
 * @author Yashwanth
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args.length);
		main("private",args);
	}
	private static void main (String type,String[] args){
		
		System.out.println(args[0]+args[1]);
	}

}
