package com.jdiaz02.zookeeper2;

public class Mammal {
//	don't forget access modifier i.e protected or private
	protected Integer energy = 300;
	
	
	public Integer displayEnergy() {
		System.out.println("Energy Level:" + energy);
		return energy;
	}

	
}
