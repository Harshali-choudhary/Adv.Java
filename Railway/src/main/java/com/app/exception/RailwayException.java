package com.app.exception;

public class RailwayException extends RuntimeException{
	private String mesg;
	
	public RailwayException(String m)
	{
		super(m);
		mesg=m;
	}

}
