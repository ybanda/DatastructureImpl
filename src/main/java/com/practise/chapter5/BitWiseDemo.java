package com.practise.chapter5;

import java.math.BigInteger;

public class BitWiseDemo {

	public static void main(String[] args) {
		
		int bitmask = 0x000F;
        int val = 0x2222;
        //System.out.println(val & bitmask);
		//And
        //0 & 0 = 0,  1 & 1 = 1, 1 & 0 = 0 & 1 = 0
        System.out.println("Operation \t 0,0\t 0,1\t 1,0\t 1,1");
        System.out.println("-------------------------------------------------------");
        System.out.print("AND& \t\t");
        System.out.print(0&0);
        System.out.print("\t");
        System.out.print(0&1);
        System.out.print("\t");
        System.out.print(1&0);
        System.out.print("\t");
        System.out.print(1&1);
        System.out.println();
        
        System.out.print("OR| \t\t");
        System.out.print(0|0);
        System.out.print("\t");
        System.out.print(0|1);
        System.out.print("\t");
        System.out.print(1|0);
        System.out.print("\t");
        System.out.print(1|1);
        System.out.println();

        System.out.print("XOR^ \t\t");
        System.out.print(0^0);
        System.out.print("\t");
        System.out.print(0^1);
        System.out.print("\t");
        System.out.print(1^0);
        System.out.print("\t");
        System.out.print(1^1);
        System.out.println();
        
        System.out.print("LShift<< \t");
        System.out.print(1000<<1);
        System.out.print("\t");
        System.out.print(0<<1);
        System.out.print("\t");
        System.out.print(1<<0);
        System.out.print("\t");
        System.out.print(1<<1);
        System.out.println();
        

        System.out.print("RShift<< \t");
        System.out.print(1000>>0);
        System.out.print("\t");
        System.out.print(0>>1);
        System.out.print("\t");
        System.out.print(1>>0);
        System.out.print("\t");
        System.out.print(1>>1);
        System.out.println();
        
        BigInteger n = new BigInteger("10000000000",2);
        
        BigInteger m = new BigInteger("10101",2);
        
        int a1 =updateBits(n.intValue(),m.intValue(),2,6);
        
        BigInteger a = new BigInteger(a1+"",10);
        
        System.out.println(a.toString(2));
        System.out.println(printBinary("3.72"));
	}
	
	public static int updateBits(int n, int m, int i, int j) {
		
		int max = ~0; /* All 1’s */

	    // 1’s through position j, then 0’s
		 int left = max - ((1 << j) );
		 
		 System.out.println(left);
		
		 // 1’s after position i
		 int right = ((1 << i) );
		
		 // 1’s, with 0s between i and j
		 int mask = left | right;
		 
		
		// Clear i through j, then put m in there
		 return (n & mask) | (m << i);
		 }
	
	public static String printBinary(String n)
	{
	    int intPart = Integer.parseInt(n.substring(0, n.indexOf('.'))); // integer part, xxxx
	    double decPart = Double.parseDouble(n.substring(n.indexOf('.'), n.length())); // decimal part, 0.xxxx 
	    String int_string = "";
	
	    while (intPart > 0)
	    {
	        int r = intPart % 2;
	        intPart >>= 1; // int part / 2
	        int_string = r + int_string; // append to front , not back.
	    }
	    
	    StringBuffer dec_string = new StringBuffer();
	    System.out.println(decPart+"/////"+dec_string.length());
	    
	    while (decPart > 0)
	    {
	        if (dec_string.length() > 32) 
	        	return "ERROR"; // if too long, return error.
	        if (decPart == 1) { // if decimal part is 1, then append 1 to string and break loop.
	            dec_string.append((int)decPart); 
	            break; // == 1 is the only time will break.
	        }
	        double r = decPart * 2; // doubles decimal part.
	        if (r >= 1) { // if after*2, >=1 , then append 1 to string, at the back
	            dec_string.append(1);
	            decPart = r - 1; //after append, assign doubled decpart-1 to decpart.
	        } else {      // if after*2, < 1 then append 0 to string a
	            dec_string.append(0);
	            decPart = r; // decPart is doubled without -1.
	        }
	    }
	    return int_string + "." + dec_string.toString(); // concatenate  2 strings together.
	}
}