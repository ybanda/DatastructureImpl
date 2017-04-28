package com.practise.java8;

import java.util.Scanner;

public class C1 {
	   public static void main(String []argh){
	        Scanner in = new Scanner(System.in);
	        int t=in.nextInt();
	        for(int i=0;i<t;i++){
	            int a = in.nextInt();
	            int b = in.nextInt();
	            int n = in.nextInt();
	            Double result =0.0;
	            for(int j=0;j<n;j++)
	            {  
	              //  while()
	                result = result+((Math.pow(2,j)*b));
	                System.out.print(""+result.intValue()+" ");
	                if(j+1==n)
	                {
	                    result=0.0;
	                    System.out.println("");
	                }
	            }
	        }
	        in.close();
	    }
}
