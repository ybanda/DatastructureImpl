/**
 * 
 */
package com.ocajp8.ch4.arrays;

/**
 * @author Yashwanth
 *
 */
public class ArraysImpl {
	static String objArray[] = new String[]{"Yash","KR","Banda"};
	static int intArray[][] = new int[4][8];
	static int int2DArray[][]= {{12,12},{1,2},{3,4},{5,6},{89,90}};
	String mulitStringArr[][] = new String[][]{
		{"A","B"},
		null,
		{"Jan","feb","mar"},
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<intArray.length;i++){
			for(int j=0;j<intArray[i].length;j++){
				intArray[i][j] = i+j;
			}
		}
		intArray[3][4]=1100;
		System.out.println("--------------------String Array ------------");
		printString(objArray);
		System.out.println("--------------------2D Array ----------------");
		print2DArray(intArray);
		System.out.println("--------------------2D Array ----------------");
		print2DArray(int2DArray);
		
	}

	/**
	 * 
	 * @param intArray2
	 */
	private static void print2DArray(int[][] intArray2) {
		for(int i=0;i<intArray2.length;i++){
			for(int j=0;j<intArray2[i].length;j++){
			System.out.println("["+i+"]["+j+"] ="+intArray2[i][j]);
			}
		}
	}

	/**
	 * 
	 * @param arrayStr
	 */
	public static void printString(String[] arrayStr){
		for(Object obj:arrayStr){
			System.out.println(obj.toString());
		}
	}
}
