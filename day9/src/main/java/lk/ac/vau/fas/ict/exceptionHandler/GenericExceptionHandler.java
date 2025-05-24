package lk.ac.vau.fas.ict.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import lk.ac.vau.fas.ict.model.ErrorResponse;

@RestControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException exception) {
		ErrorResponse errorResponce = new ErrorResponse(HttpStatus.NOT_FOUND.value(), 
				exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponce, HttpStatus.NOT_FOUND);
	}

}
