package com.datastructures.sorting;

public class SelectionSort {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {4,6,7,5,9,23,1,0,22};
		
		doSelectionSort(arr);
	}

	/**
	 * 
	 * @param arr
	 */
	private static void doSelectionSort(int[] arr) {
		
		
		
		for(int i=0;i<arr.length;i++)
		{
			int minIndex = i;
			for(int j=i;j<arr.length;j++)
			{
				if(arr[minIndex]>arr[j])
				{
					minIndex=j;
				}
			}
			
			int temp =arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
			BubbleSort.printNumbers(arr);
		
			
		}
	}
}
