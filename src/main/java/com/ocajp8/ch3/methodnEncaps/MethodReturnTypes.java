/**
 * 
 */
package com.ocajp8.ch3.methodnEncaps;

/**
 * @author Yashwanth
 *
 */
public class MethodReturnTypes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		returnVoid();
		returnVoid(23);
		returnString();
		returnboolean();
		returnInt();
		returnfloat();
		returnByte();
		returndouble();
		System.out.println(totalCount("Yashwanth",2,1,32,123,44,22,555,77,88));
	}
	
	public static int totalCount(String name ,int... nums){
		int total=0;
		System.out.println("Array Length ::"+name+"::Length::"+nums.length);
		for (int i=0;i<nums.length;i++)
			total+=nums[i];
		return total;
	}

	public static void returnVoid(){
		System.out.println("Void method");
	}
	public static void returnVoid(int index){
		if(index>0)
			return;
		else
			System.out.println("Void method");
	}
	
	public static String returnString(){
		System.out.println("String method");
		
		return "String";
	}
	
	public static boolean returnboolean(){
		System.out.println("boolean method");
		return true;
	}
	
	
	public static int returnInt(){
		System.out.println("Int method");
		return 1;
	}
	
	public static float returnfloat(){
		System.out.println("float method");
		return 1f;
	}
	
	public static byte returnByte(){
		System.out.println("Byte method");
		return 1;
	}
	
	public static double returndouble(){
		System.out.println("double method");
		return 1.2;
	}
}
