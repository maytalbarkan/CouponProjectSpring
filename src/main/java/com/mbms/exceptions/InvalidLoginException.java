package com.mbms.exceptions;



@SuppressWarnings("serial")
public class InvalidLoginException extends CouponSystemException {
	public InvalidLoginException() {
		super("Password or user name is incorrect");
	}
}