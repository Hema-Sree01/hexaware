package com.hexaware.medicalbillingsystems.exception;


import org.springframework.http.HttpStatusCode;

import org.springframework.web.server.ResponseStatusException;

/*
@Author :   Hema Sree  
Modified Date : 16-10-2023
Description : Getting the exception of PlanNotFoundException
*/
public class PlanNotFoundException extends ResponseStatusException {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public PlanNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);
	}
}