package com.caresoft.clinicapp;

public interface HIPAAComplientUser {
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}

