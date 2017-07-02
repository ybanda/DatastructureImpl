/**
 * 
 */
package com.ocajp8.ch4.arrays;

import java.util.ArrayList;
import java.util.List;

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
		printList(arrClone);
		
		
		System.out.println("Array :: contains :: R :: "+arr.contains("R"));
		System.out.println("Array :: Index of :: B :: "+arr.indexOf("B")+":: Last Index of :: "+arr.lastIndexOf("B"));

		System.out.println("Check Cloned ==  "+(arr==arrClone));
	}
	
	/**
	 * 
	 * @param listObj
	 */
	public static void printList(List<Object> listObj){
		
		System.out.println("List Capacity :: "+listObj.size());
		for(Object obj:listObj){
			System.out.println("Value in the array :: "+obj.toString());
		}
	}
}
