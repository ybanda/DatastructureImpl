/**
 * 
 */
package com.ocajp8.ch3.methodnEncaps;

/**
 * @author Yashwanth
 *
 */
public class TestPhone {
	
	public int countInstanceVar, phoneNumber=8888;
    public static int countClassVar=8888,phoneNumbers=8888;
	
	public void setPhoneNumber(){
		int phoneNumber;
		phoneNumber=9999999;
		phoneNumbers=99999999;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int phoneNumber=7777;
		phoneNumbers=1234;
		
		TestPhone testPhoneObj = new TestPhone();
		Phone.softKeyboard=false;
		Phone p1 = new Phone();
		Phone p2 = new Phone();
		
		System.out.println(p1.softKeyboard);
		System.out.println(p2.softKeyboard);
		p1.softKeyboard=true;
		System.out.println(p1.softKeyboard);
		System.out.println(Phone.softKeyboard);
		
		System.out.println("Instance Variable :: Count Instance :: "+testPhoneObj.countInstanceVar);
		
		System.out.println("Class Variable :: ClassVar :: "+countClassVar);
		System.out.println(phoneNumber +" Global "+testPhoneObj.phoneNumber);
		System.out.println(phoneNumbers +" Global "+TestPhone.phoneNumbers);
		
		testPhoneObj.setPhoneNumber();
		
		System.out.println(phoneNumber +" Global "+testPhoneObj.phoneNumber);
		System.out.println(phoneNumbers +" Global "+TestPhone.phoneNumbers);
		
		
		Phone phone = new Phone();
		phone.setUserName("Yashwanth Banda");
		phone = null;
		phone = new Phone();
		phone.setUserName("Yash Banda");
	}
}
