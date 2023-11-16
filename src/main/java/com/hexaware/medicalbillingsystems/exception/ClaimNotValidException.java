package com.hexaware.medicalbillingsystems.exception;


import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ClaimNotValidException extends ResponseStatusException{

	public ClaimNotValidException(HttpStatusCode status, String reason) {
		super(status, reason);

	}

	

}