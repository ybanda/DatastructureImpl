package com.practise.maths;

import java.math.BigInteger;

public class Practise {

	public static void main(String[] args) {

		//System.out.println(isPowerofThree(3486784401));
		//System.out.println(is_power_of_3(new BigInteger("1162261467").intValue()));
		createNumberGreaterThanB(1234567890,1234);
	
}
/*
Given 2 large number A and B, create a new number C using the digits from A which needs to be grater than B. 
e.g. A = 5281, B = 7443 
C = 8125.
 * 
 */
	private static int createNumberGreaterThanB(int a,int b) {
		char[] arr = String.valueOf(a).toCharArray();
		char[] barr= String.valueOf(b).toCharArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			System.out.println(barr[barr.length-1]);
		}
		return 0;
	}
	
	public static int is_power_of_3(int n)
    {

		while (n % 3 == 0) {
			System.out.println(n);
		    n /= 3;
		}
		return (n == 1)?1:0;
       
    }
}
