/**
 * 
 */
package com.ocajp8.ch6.inheritance;

import java.time.LocalDateTime;

/**
 * @author Yashwanth
 *
 */
interface BasicInterface {
	void basicAbstractMethod();
	default void obtainStatus() {
		System.out.println("BasicInterface :: Status = Accepted");
	}
	
	default void obtainFailStatus(){
		System.out.println("BasicInterface :: Status = Failed");
	}
	
	static void initalizeStatus(LocalDateTime dateTime, int duration){
		System.out.println("BasicInterface :: Status Start Time = "+dateTime.toString());
		System.out.println("BasicInterface :: Status Duration = "+duration);
	}
}
