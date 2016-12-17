package com.practise.sorting;

public class BubbleSort {
  
	/**
	 * 
	 * @param ar
	 * @return
	 */
	public static int[] bubbleSort(int ar[])
	{
	   for (int i =0;i<ar.length; i++)
	   {
	      for (int j = 0; j < ar.length-1; j++)
	      {
	         if (ar[j+1] < ar[j])
	         {
	              int temp = ar[j+1];
	              ar[j+1] = ar[j];
	              ar[j] = temp;
	              
	         }
	         printNumbers(ar);
	     }
	  } 
	   
	   return ar;   
	}
	  /**
     * 
     * @param input
     */
    public static void printNumbers(int[] input) {
          
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
  
    public static void main(String[] args) {
        int[] input = {4,6,7,5,9,23,1,0,22};
     
  printNumbers(bubbleSort(input));
    }
}
