package com.practise.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {4,6,7,5,9,23,1,0,22};
		doInsertionSort(arr);
		
	}
	/**
	 * 
	 * @param arr
	 */
	private static void doInsertionSort(int[] input) {
		
		int temp;
		
		for (int i = 1; i < input.length; i++)
		{
            for(int j = i ; j > 0 ; j--)
            {
                if(input[j] < input[j-1])
                {
                    temp = input[j];
                    
                    input[j] = input[j-1];
                    
                    input[j-1] = temp;
                    
                    BubbleSort.printNumbers(input);
                }
            }
        }
	}
}
