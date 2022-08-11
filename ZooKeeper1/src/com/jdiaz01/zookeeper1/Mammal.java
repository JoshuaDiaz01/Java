package com.jdiaz01.zookeeper1;

public class Mammal {
//	dont forget access modifier i.e protected or private
	protected Integer energy = 100;
	
	
	public Integer displayEnergy() {
		System.out.println("Energy Level:" + energy);
		return energy;
	}

	
}
