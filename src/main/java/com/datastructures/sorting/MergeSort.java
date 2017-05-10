package com.datastructures.sorting;

public class MergeSort {
    
    private int[] array;
    
    private int[] tempMergArr;
    
    private int length;
 
    public static void main(String a[])
    {
         
        int[] inputArr ={24,2,45,20,56,75,27,56,99,53,12};
    
        MergeSort mms = new MergeSort();
        
        mms.sort(inputArr);
        
        BubbleSort.printNumbers(inputArr);
    }
     
    public void sort(int inputArr[])
    {
        this.array = inputArr;
    
        this.length = inputArr.length;
        
        this.tempMergArr = new int[length];
        
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
       
    	 System.out.println(lowerIndex +" --- ---"+ higherIndex);
    	 
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
           
            System.out.println(lowerIndex +" --- "+middle+"---"+ higherIndex);
            
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
    	  BubbleSort.printNumbers(array);
    	  
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
       
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
}
