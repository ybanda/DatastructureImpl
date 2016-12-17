package com.practise.sorting;
/*
Algorithm to create swoosh logo
 
 e.g Swoosh logo with maximum width 15
 - - - x x x x x x x x x - - - 
- x x x x x x x x x x x x x - 
x x x x x x x x x x x x x x x 
x x x x x x x x x x x - - - - 
x x x x x x x - - - - - - - - 
x x x x x - - - - - - - - - - 
- x x x x x - - - - - - - - - 
- - - x x x x - - - - - - - -
 */

import java.util.LinkedList;
import java.util.List;

public class SwooshLogo
{
	private int maxWidth;
	
	public SwooshLogo(int maxWidth)
	{
		this.maxWidth = maxWidth;
	}
	
	/**
	 * It prints all the list of strings to display the swoosh pattern
	 * @param list - List of strings to be displayed
	 */
	private void printSwooshOnConsole(List<String> patternList)
	{
		for ( int i = 0 ; i < patternList.size() ; ++i)
		{
			for(int j = 0 ; j < patternList.get(i).length() ; ++j)
			{
				System.out.print(patternList.get(i).charAt(j) + " ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Helper function to rotates a string n no of times
	 * @param str - string to be rotated
	 * @param noOfTimes - no of times to be rotated
	 * @return
	 */
	private String rotateString(String str, int noOfTimes)
	{
		for(int i = 0 ; i < noOfTimes ; i++)
		{
			str = str.charAt(str.length()-1) + str.substring(0, str.length()-1); 
		}
		return str;
	}
	
	/**
	 * Prints the swoosh pattern with max width on the console output
	 * @param maxWidth - max width to be displayed
	 */
	public void drawSwooshOnConsole() 
	{
		List<String> list = new LinkedList<String>();
		
		int center = maxWidth/2;
		int noOfBlanksFromRight = (int) Math.ceil((double)maxWidth/4);;
		int noOfRowsBelowMaxWidth = 0;
		int value =0 ;
		
		do
		{
			value = value + noOfBlanksFromRight;
			++noOfRowsBelowMaxWidth;
			String str = new String();
			
			for(int i = 0 ; i < maxWidth - value ; i++)
			{
				str = str.concat("x");
			}
			
			for(int i = maxWidth - value ; i < maxWidth  ; i++)
			{
				str = str.concat("-");
			}
			
			list.add(str);
			
		}while (value < center);
		
		
		noOfBlanksFromRight = noOfBlanksFromRight/2;
		
		String str = new String();
		
		for(int i = 0 ; i < maxWidth - ((value)+noOfBlanksFromRight) ; i++)
		{
			str = str.concat("x");
		}
		
		for(int i = maxWidth - ((value)+noOfBlanksFromRight) ; i < maxWidth  ; i++)
		{
			str = str.concat("-");
		}
		
		noOfRowsBelowMaxWidth++;
		list.add(str);
		
		int rotate = 1;
		str = rotateString(str,rotate);
		
		while(str.contains("x") && str.lastIndexOf('x')-1 < center)
		{
			
			noOfRowsBelowMaxWidth++;
			list.add(str);
			
			int index = str.lastIndexOf('x');
			str = str.substring(0,index)+'-'+str.substring(index+1);
			
			rotate = rotate+1;
			str = rotateString(str,rotate);
		}
		
		str = new String();
		
		for(int i = 0 ; i < maxWidth ; i++)
		{
			str = str.concat("x");
		}
		
		list.add(0, str);
		
		int noOfRowsAboveMaxWidth = noOfRowsBelowMaxWidth/2;
		
		int noOfSpace = 1;
		
		for ( int i = 1 ; i <= noOfRowsAboveMaxWidth ; i++)
		{
			str = new String();
			for(int j = 0 ; j < noOfSpace ; j++)
			{
				str = str.concat("-");
			}
			for(int j = 0 ; j < maxWidth - 2*noOfSpace ; j++)
			{
				str = str.concat("x");
			}
			
			for(int j = 0 ; j < noOfSpace ; j++)
			{
				str = str.concat("-");
			}
			noOfSpace = noOfSpace+2;
			list.add(0, str);
		}
		
		printSwooshOnConsole(list);
	}
	
	public  static void main(String args[])
	{
		int width = 123;
		
		SwooshLogo s = new SwooshLogo(width);
		s.drawSwooshOnConsole();
	}
}