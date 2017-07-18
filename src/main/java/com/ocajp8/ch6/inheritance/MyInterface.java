package com.ocajp8.ch6.inheritance;

public interface MyInterface extends Jumpable,Moveable{

	@Override
	default void returnDefault() {
		// TODO Auto-generated method stub
		Moveable.super.returnDefault();
	}
	

}
