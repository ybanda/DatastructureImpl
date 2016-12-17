/**
 * 
 */
package com.practise.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yashwanth 
 *
 */
public class LambdaExpImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int numq =0_5__0__1;
		System.out.println(numq);
		int[] integerList={1,2,3,4};

		List<Integer> au =new ArrayList<Integer>();
		
		au.add(1);
		
		au.add(2);
		
		au.add(3);
		
		au.add(4);
		
		au.add(5);
		
		au.add(6);
		
		au.forEach(System.out::println);
		
		MathOperation add = (list,num )->list.contains(num);

		System.out.println(add.isContains(au, 1));
		
		/*MathOperation add = (int a,int b)->a+b;

		add=(int a,int b)->a+2*b;

		MathOperation sub =(int a, int b)->a-b;*/

		Hello hel = msg->System.out.println("Hello="+msg);

		Hello hel1 = (msg)->System.out.println("Hello::::"+msg);

		/*
		System.out.println("Addition of 2 numbers=="+LambdaExpImpl.operate(10,4,add ));

		System.out.println("Subtraction of 2 numbers=="+LambdaExpImpl.operate(10,4,sub ));*/

		hel.printHello("Tested");

		hel1.printHello("Testing");

	}

	/*interface MathOperation
	{
		int operation(int a , int b);


	}
	interface Hello
	{
		void printHello(String msg);
	}*/
	
	interface MathOperation
	{
		//int operation(int a , int b);
		boolean isContains(List<Integer> list,int num);

	}
	
	interface Hello
	{
		void printHello(String msg);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param mathOperation
	 * @return
	 */
	private static int operate(int a , int b , MathOperation mathOperation)
	{
		return 0;
		//return mathOperation.operation(a,b);
	}
}
