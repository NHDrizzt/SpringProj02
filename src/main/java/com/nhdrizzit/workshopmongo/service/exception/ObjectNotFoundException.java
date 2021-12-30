package com.nhdrizzit.workshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException{
	static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
