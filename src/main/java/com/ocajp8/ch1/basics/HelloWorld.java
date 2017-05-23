/**
 * 
 */
package com.ocajp8.ch1.basics;
/**
 * @author Yashwanth
 *
 */
class Hello{
	 String name;
}
public class HelloWorld {

	/**
	 * @param args
	 */
	static  public  void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args.length);
		main("private",args);
		System.out.println("tESTING MAIN");
		Hello h = new Hello();
		System.out.println(h.name);
	}
	private static void main (String type,String[] args){

		System.out.println(args[0]+args[1]);
		System.out.println(args[1]+":"+args[2]+":"+args[3]);
	}

}
