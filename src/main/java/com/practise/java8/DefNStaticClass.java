/**
 * 
 */
package com.practise.java8;

/**
 * @author Yashwanth
 *
 */
public class DefNStaticClass implements DefNStaticInterface,DefNStaticInterface1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefNStaticClass defaultClass  = new DefNStaticClass();
		defaultClass.log("Default Methods can be called thru Object instance");
		defaultClass.toString1();
		DefNStaticInterface defInterface = new DefNStaticClass();
		defInterface.testMethod("Implemented Abstract Method ");
		DefNStaticInterface1.log("Calling the Static Methods Directly Via","InterfaceName.StaticMethodName");
	

	}

	/**
	 * 
	 */
	@Override
	public void testMethod(String input) {
		System.out.println(input);
		
	}

	/**
	 * 
	 */
	@Override
	public void testMethod1() {
		// TODO Auto-generated method stub
		
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
