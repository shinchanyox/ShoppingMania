package com.exception;

public class InvalidPasswordException extends Exception {
	
	public InvalidPasswordException(){}
	public InvalidPasswordException(String s)
	{
		super(s) ;
	}

}
