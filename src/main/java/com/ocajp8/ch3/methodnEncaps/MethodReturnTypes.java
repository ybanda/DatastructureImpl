/**
 * 
 */
package com.ocajp8.ch3.methodnEncaps;

/**
 * Information Hiding = Encapsulation of a Class
 * @author Yashwanth
 *
 */
public class MethodReturnTypes {
	
	//Exposing Object Functionality using Public Methods
	private int num ;
	private double salary;
	
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}


	/**
	 * 
	 */
	 public MethodReturnTypes() {
		this(122);

		System.out.println(" # 3 Invoking a constructor from other constructor, this() must be the first statement");
		num =50;
		System.out.println(" # 3 Value of Num set by default Constructor ="+num);
	}
 
	
	public MethodReturnTypes(int num) {
		//this();
		System.out.println(" # 3 Value of Num set by single param Constructor ="+num);
	}
	
	{
		System.out.println(" # 2 I `m from Initializer Block- created only before calling constructor , i.e, before object creation");
	}
	
	static{
		System.out.println("# 1 I`m From Static Initializer Block, called must even without object creation");
	}
	
	/**
	 * 
	 */
	public void MethodReturnTypes() {
		num =500;
		System.out.println(" # 4 Value of Num set by Regular Method ="+num);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("# 1 Static Method main() Executed First");
		returnVoid();
		returnVoid(23);
		returnString();
		returnboolean();
		returnInt();
		returnfloat();
		returnByte();
		returndouble();
		System.out.println(" 	"+totalCount("Yashwanth",2,1,32,123,44,22,555,77,88));
		MethodReturnTypes method = new MethodReturnTypes();
		method.MethodReturnTypes();
		MethodReturnTypes method1 = new MethodReturnTypes(12333);
	
		
	}
	
	public static int totalCount(String name ,int... nums){
		int total=0;
		System.out.println("	Array Length ::"+name+"::Length::"+nums.length);
		for (int i=0;i<nums.length;i++)
			total+=nums[i];
		return total;
	}

	public static void returnVoid(){
		System.out.println("	Void method");
	}
	public static void returnVoid(int index){
		if(index>0)
			return;
		else
			System.out.println("	Void method");
	}
	
	public static String returnString(){
		System.out.println("	String method");
		
		return "String";
	}
	
	public static boolean returnboolean(){
		System.out.println("	boolean method");
		return true;
	}
	
	
	public static int returnInt(){
		System.out.println("	Int method");
		return 1;
	}
	
	public static float returnfloat(){
		System.out.println("	float method");
		return 1f;
	}
	
	public static byte returnByte(){
		System.out.println("	Byte method");
		return 1;
	}
	
	public static double returndouble(){
		System.out.println("	double method");
		return 1.2;
	}
	
}
