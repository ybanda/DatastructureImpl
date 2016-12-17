package com.practise.online;

import java.math.BigInteger;

public class KeyCode {

	public static void main(String[] args) {
		
		int sum =0;
		for(int i=4;i<=9;i++)
		{
			sum+= factorial(i);
			
		}
	System.out.println(sum);
	AndroidLockPattern.numberOfPatterns(); 
	}
	
public static int factorial(int number)
	{
	int num=1;
	while(number>1)
		{
			num *= number;
			number--;
		}
	
	return num;
}
static class AndroidLockPattern {
	
	private static boolean used[] = new boolean[9];
	
	private static boolean isValid(int index, int last) {		
		if (used[index])
			return false;
		if(last == -1)
			return true;				
		// knight moves 
		if((index + last)%2 == 1)
			return true;
		// indexes are from both side of the diagonals for example 0,0, and 8,8
		int mid = (index +last)/2;
		if ( mid == 4)
			return used[4];
		// adajcent cells on diagonal  - for example 0,0 and 0,1
		if ((index%3 != last%3) && (index/3 != last/3)) {
			return true;
		}
		// all other adjacent cells (two cells in one row or two cells in one column)
		return used[mid];	
		
	}
	
	public static void numberOfPatterns() {
		int res =0;
		for (int len = 4; len <= 9; len++) {				
			res += calcPatterns(-1,len);	
			for (int i = 0; i < 9; i++) {
				used[i] = false;					
			}
		}
		System.out.println(res);
	}
	
	
	private static int calcPatterns(int last,int len) {
		if (len == 0) {				
			return 1;				
		} 
		else {
			int sum = 0;
			for (int i = 0; i < 9; i++) {									
				if (isValid(i, last)) 
				{
						used[i] = true;															
						sum += calcPatterns(i, len - 1);
						used[i] = false;					
				}
			}
			return sum;
		}			
	}
}
}
