package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAAComplientUser {

	public Physician(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public boolean assignPin(int pin) {
		if (pin < 1000 || pin > 9999) {
		    System.out.println("Error pin must be 4 digit");
		    return false;
		}
		else {
		    System.out.println("Valid Pin");
		    return true;
		}
	}
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id.equals(confirmedAuthID)) {
			return true;
		}
		else {
			return false;
		}
			
	}
		
		
	//... imports class definition...
	    
	// Inside class:    
	private ArrayList<String> patientNotes;
		
	// TO DO: Constructor that takes an ID
	// TO DO: Implement HIPAACompliantUser!
		
	public void newPatientNotes(String notes, String patientName, Date date) {
	String report = String.format("Datetime Submitted: %s \n", date);
	report += String.format("Reported By ID: %s\n", this.id);
	report += String.format("Patient Name: %s\n", patientName);
	report += String.format("Notes: %s \n", notes);
	this.patientNotes.add(report);
	}
		
	    // TO DO: Setters & Getters
		
	

}
