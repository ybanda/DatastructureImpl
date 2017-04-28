/**
 * 
 */
package com.practise.java8;

/**
 * @author Yashwanth
 *
 */
public interface DefNStaticInterface1 {

	public void testMethod1();
	public void testMethod(String input);
	/**
	 * 
	 * @param input
	 * @param name
	 */
	static void log(String input , String name)
	{
		System.out.println("String Input is "+input+":: with name :: "+name);
	}

	/**
	 * 
	 * @return
	 */
	default String toString1()
	{
		return 	"Returned the String # 1";
	}
}
