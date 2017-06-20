/**
 * 
 */
package com.ocajp8.ch4.arrays;

/**
 * @author Yashwanth
 *
 */
public class StringMethodImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = new String("Yashwanth");
		String str2 = new String("Yashwanth");
		String str3 = "Yashwanth  ";
		String str4 = "Yashwanth";
		String str5 = new String("Yashwanth");
		char[] charName = new char[]{'Y','a','s','h','w','a','n','t','h'};
		String str6 = new String(charName);
		String str7 = null;
		
		System.out.println("str1 HasCode :: "+str1.hashCode());
		str1 ="BYKR";
		System.out.println("str1 HasCode :: "+str1.hashCode());
		System.out.println("str2 HasCode :: "+str2.hashCode());
		System.out.println("str3 HasCode :: "+str3.hashCode());
		System.out.println("str4 HasCode :: "+str4.hashCode());
		System.out.println("str5 HasCode :: "+str5.hashCode());
		System.out.println("str6 HasCode :: "+str6.hashCode());
		//System.out.println("str7 HasCode :: "+str7.hashCode());

		System.out.println("Str1Obj == Str2Obj :: returns ::"+stringValueCompare(str1, str2));
		System.out.println("Str3Var == Str4Var :: returns ::"+stringValueCompare(str3, str4));
		System.out.println("Str3Var == Str2Obj :: returns ::"+stringValueCompare(str3, str2));
		System.out.println("Yashwanth"==str3);
		System.out.println("str5Obj == Str6Obj :: returns ::"+stringValueCompare(str5,str6));
		
		stringMethodOperations(str2, str3);
	}
	/**
	 * 
	 * @param val1
	 * @param val2
	 * @return
	 */
	public static boolean stringValueCompare(String val1 , String val2){
		
	return 	(val1==val2) ?true : false; 
	}
	
	/**
	 * 
	 * @param val1
	 * @param val2
	 */
	public static void stringMethodOperations(String val1 , String val2){
		System.out.println("---------------------Query Position of Characters--------------");
		System.out.println("For String ::"+val1+" , Character at index :: 0 "+val1.charAt(0));
		System.out.println("For String ::"+val1+" , Index at Y::"+val1.indexOf('Y'));
		System.out.println("For String ::"+val1+" , SubString(0,8) "+val1.substring(0,8));
		System.out.println("---------------------Seem to modify String--------------");
		System.out.println(val2.trim() +" val2-- Length "+val2.trim().length());
		System.out.println("Replace a with r :: "+val2.replace('a', 'r') +":: Starts with :: Y ?"+val2.startsWith("Y")+
				"\n Ends with h ?"+val2.endsWith("h"));
		
	}

}
