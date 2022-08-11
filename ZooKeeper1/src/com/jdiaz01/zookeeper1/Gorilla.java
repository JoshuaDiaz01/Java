package com.jdiaz01.zookeeper1;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("Threw a banana");
		energy -=5;
	}
	
	public void eatBananas() {
		System.out.println("Yummy Banana");
		energy +=20;
	}
	
	public void climb() {
		System.out.println("Climbing");
		energy -= 15;
	}
	
	
}
