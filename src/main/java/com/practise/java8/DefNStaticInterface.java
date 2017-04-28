/**
 * 
 */
package com.practise.java8;

/**
 * @author Yashwanth
 *
 */
public interface DefNStaticInterface {

	void testMethod(String input);
	
	/**
	 * 
	 * @param input
	 */
	default void log(String input)
	{
		System.out.println("String Given is "+input);
	}
	
	/**
	 * 
	 * @param input
	 * @param name
	 */
	static void log(String input , String name)
	{
		System.out.println("String Input is :: "+input+"::"+name);
	}

}
