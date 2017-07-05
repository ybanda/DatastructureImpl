/**
 * 
 */
package com.ocajp8.ch6.inheritance;

/**
 * @author Yashwanth
 *
 */
public class LivingBeing implements Jumpable,Moveable {

	public LivingBeing() {
		// TODO Auto-generated constructor stub
		System.out.println(MIN_DISTANCE);
		System.out.println(MIN_DISTANCE_1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LivingBeing lv = new LivingBeing();
		lv.getMinDistance();

	}

//	@Override
//	public int getMinDistance() {
//		// TODO Auto-generated method stub
//		return 1000;
//	}
	

	@Override
	public void getMinDistance() {
		// TODO Auto-generated method stub
		
	}
}
