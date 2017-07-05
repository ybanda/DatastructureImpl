package com.ocajp8.ch6.inheritance;

import java.time.LocalDateTime;

/**
 * 
 * @author Yashwanth
 *
 */
class Employee implements BasicInterface{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Employee Class --- Main Method---- Start ----");
		BasicInterface initInterface = new Employee();
		initInterface.basicAbstractMethod();
		initInterface.obtainStatus();
		initInterface.obtainFailStatus();
		BasicInterface.initalizeStatus(LocalDateTime.now(),156);
		Employee.employeeStatus();
		employeeStatus();
		//Programmer p1 = new Programmer();
		
		System.out.println("Employee Class --- Main Method---- End ----");
	}

	@Override
	public void basicAbstractMethod() {
		System.out.println("Employee :: Interface Method implemented");
	}
	
	static void employeeStatus(){
		System.out.println("Employee :: Employee Status :: ");
	}
	
	/**
	 * 
	 * @author Yashwanth
	 *
	 */
	class Programmer extends Employee{
		
	}
	
	/*class Architect extends Employee{
		
	}*/
}
