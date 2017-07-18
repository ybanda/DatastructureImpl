/**
 * 
 */
package com.ocajp8.ch6.inheritance;

/**
 * @author Yashwanth
 *
 */
public interface Jumpable {
	int MIN_DISTANCE= 100;
	abstract void getMinDistance();
	abstract String getPosition();
	default void returnDefault(){
		System.out.println("Default :: Jumpable");
	}
	
}
