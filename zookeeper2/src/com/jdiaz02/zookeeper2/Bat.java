package com.jdiaz02.zookeeper2;

public class Bat extends Mammal { //using extends to get energy level and displayEnergy();
	
	
	
	public void fly() {
		System.out.println("pspspssspssspsss");
		energy -= 30;
	}
	
	public void eatHumans() {
		System.out.println("nom nom nom yummy flesh");
		energy += 50;
	}
	
	public void attackTown() {
		System.out.println("Bang Bang you will all die!!");
		energy -= 100;
	}
	
	
}
