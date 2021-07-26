package com.longnguyenquy.dto;

public enum StatusType {

	// enum fields
	PENDING(1), CONFIRMED(2), CANCELLED(3), READY(4) , SHIPPING(5) , REFUNDED(6);
 
    // constructor
    private StatusType(final int value) {
        this.value = value;
    }
 
    // internal state
    private int value;
 
    public int getValue() {
        return value;
    }
	
	
}

