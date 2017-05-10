/**
 * 
 */
package com.practise.online;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yashwanth
 *
 */
public class ReadKLines {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		readKLinesInFile();

	}

	private static void readKLinesInFile() {
	
		int k =35,count=0,start=0,lines=0;
		List<String> values ;
	
		try
		{
			values = new ArrayList<String>();
			
			Scanner fr = new Scanner(new File("data.txt"));

			while(fr.hasNextLine())
			{
				values.add(lines,fr.nextLine());
				lines++;
			}
			if(lines<k)
			{
			start=0;
			count=lines;
			}
			else
			{
				start = lines%k;
				count =k;
			}

			for(int i=1;i<=count;i++)
			{				
				System.out.println(values.get(values.size()-i));
			}
			
			}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
	}

}
