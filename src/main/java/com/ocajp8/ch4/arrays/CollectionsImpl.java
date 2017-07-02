/**
 * 
 */
package com.ocajp8.ch4.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Yashwanth
 *
 */
public class CollectionsImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arrayListClassImpl();
	}

	/**
	 * 
	 */
	public static void arrayListClassImpl(){
		
		ArrayList<Object> arr = new ArrayList<>();
		arr.add("Yashw");
		arr.add("Kumar");
		arr.add("Reddy");
		arr.add("Banda");
		List arrayVal = new ArrayList(120);
		arrayVal.add("Y");
		arrayVal.add("B");
		arrayVal.add("K");
		arrayVal.add("R");
		arrayVal.add("B");
		arrayVal.add(4, "119");
		arrayVal.set(0, "1119");
	
		//arrayVal.clear();
		System.out.println("Size of List:: "+arrayVal.size());
		arr.addAll(arrayVal);
		System.out.println("Array Index :: 0 :: "+arr.get(0));
		printList(arr);
		arr.remove("K");
		arr.remove(0);
		printList(arr);
		ArrayList<Object> arrClone = (ArrayList<Object>)arr.clone();
		printListWithIterator(arrClone);
		
		
		System.out.println("Array :: contains :: R :: "+arr.contains("R"));
		System.out.println("Array :: Index of :: B :: "+arr.indexOf("B")+":: Last Index of :: "+arr.lastIndexOf("B"));

		System.out.println("Check Cloned ==  "+(arr==arrClone));
		
		ArrayList<String> myArr = new ArrayList<String>();
		String one ="One";
		String two = new String("Two");
		myArr.add(one);
		myArr.add(two);
		ArrayList<String> urArr = myArr;
		one.replace("O","B");
		for (String val : myArr)
			System.out.println(val+":");

		for (String val : urArr)
			System.out.println(val+":");
	}
	
	/**
	 * 
	 * @param listObj
	 */
	public static void printList(List<Object> listObj){
		
		System.out.println("List Capacity :: "+listObj.size());
		for(Object obj:listObj)
			System.out.println("Value in the array :: "+obj.toString());
		
	}
	
	/**
	 * 
	 * @param listObj
	 */
	public static void printListWithIterator(List<Object> listObj){
		
		System.out.println("------Printing list with List Iterator----");
		ListIterator<Object> iter = listObj.listIterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
	}
}
