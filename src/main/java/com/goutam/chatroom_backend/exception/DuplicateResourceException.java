package com.goutam.chatroom_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateResourceException extends RuntimeException{

	public DuplicateResourceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
