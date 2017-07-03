/**
 * 
 */
package com.ocajp8.ch5.flowcontrol;

/**
 * @author Yashwanth
 *
 */
public class IfElseFlowControl {

	static int controlStatement =10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		ifElseFlowControl();
		//		nestedElseIfConstuct();
		//		ternaryConstuct();
		//		switchConstruct();
		//		forLoopConstruct();
		//		whileConstruct();
		//		doWhileConstruct();
			continueConstuct();
		}
	

	private static void continueConstuct() {
		
		String[] languages ={"Java","C","C#","C++"};
		for (String name :languages){
			if(name.equals("C"))
				continue;
			System.out.println(name);
		}
		
		block:{
			int[] arr ={1,2,3};
			for(int a :arr)
				System.out.println(a);
		}
		outer:
			for(int i=0;i<languages.length;i++)
				System.out.println(languages[i]);
		outer1:
			for(String out:languages){
				for(String inner :languages){
					if(inner.equals("C#"))
					{
						System.out.println("Break::"+inner);
						break outer1;
					}	else{
						System.out.println("Continue::"+inner);
						continue outer1;
					}
					
				}
			}
		
	}


	/**
	 * 
	 */
	private static void doWhileConstruct() {
		System.out.println("---Do- While -----");
		int num =9;
		boolean isDivisible =true;
		do{
			System.out.println("num::"+num);
			if(num%7==0)
				isDivisible=true;
			--num;
			}
		while(!isDivisible);
		
	}


	/**
	 * 
	 */
	private static void whileConstruct() {

		System.out.println("-----While -----");
		int num =9;
		boolean isDivisible =false;
		while(!isDivisible){
			System.out.println("num::"+num);
			if(num%7==0)
				isDivisible=true;
			--num;
			}
	}


	/**
	 * 
	 */
	private static void forLoopConstruct() {
		
		int lastIndex=25;
		for(int i=1;i<=lastIndex;i++)
			System.out.println(i);
		for(;lastIndex<50;++lastIndex)
			System.out.println(lastIndex);
	}

	/**
	 * 
	 */
	private static void switchConstruct() {
		int marks=10;	
		final int result;
		
		result =111;

		switch(marks){
		
		case 10:
			System.out.println(10);
			break;
		case 20:
			System.out.println(20);
			break;
		case 30:
			System.out.println(30);
			break;
		case 40:
			System.out.println(40);
			break;
		default:
			System.out.println("default");
		}
		String day ="MON";
		switch(day){
		case "SUN":
		case "Tue":
		case "Wed":
			System.out.println("Sunday");
			break;
		case "MON":
			System.out.println("Monday");
			break;
		case "Thu":
		case "Fri":
		default:
			System.out.println("Default Day");
		}

	}

	/**
	 * 
	 */
	private static void ternaryConstuct() {
		int index=10;
		int cost =index>5?10+index:index-10;
		int difference = index>9?index>6?index+1:index-1:index;
		System.out.println("Cost :: "+cost +" :: Difference :: "+difference);

	}

	private static void nestedElseIfConstuct() {
		int score =100;
		if(score>100)
			if(score<400)
				if(score<100)
					System.out.println("Score :: "+score);
				else
					System.out.println("Score :::"+score);
			else
				System.out.println("Tested");
		else
			System.out.println("Failed");

	}

	private static void ifElseFlowControl() {
		String output =" ";
		boolean isAllowed =false;
		if(controlStatement==100)
			output="100";

		else if(controlStatement ==50)
			output="50";
		else if(controlStatement==10)
			output="10";
		else
			output="null";

		if(isAllowed=true)
			System.out.println("True :: "+isAllowed);
		else
			System.out.println(isAllowed);
		System.out.println("Output Obtained ::"+output);
	}

}
