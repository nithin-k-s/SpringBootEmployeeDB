package com.emp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
	
	private String message;
	
	public EmployeeNotFoundException(String message) {
		this.message=message;
	}

}
