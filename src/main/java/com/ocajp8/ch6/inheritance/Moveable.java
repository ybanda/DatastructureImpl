/**
 * 
 */
package com.ocajp8.ch6.inheritance;

/**
 * @author Yashwanth
 *
 */
public interface Moveable {

	String MIN_DISTANCE_1 = "SMALL";
	abstract void getMinDistance();
	abstract String getPosition();
	default void returnDefault(){
		System.out.println("Default :: Jumpable");
	}
}
