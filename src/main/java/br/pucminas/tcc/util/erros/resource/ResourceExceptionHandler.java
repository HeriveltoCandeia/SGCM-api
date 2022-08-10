package br.pucminas.tcc.util.erros.resource;

import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.pucminas.tcc.util.erros.DataIntegrityViolationException;
import br.pucminas.tcc.util.erros.ObjectNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), "Erro na validação dos campos.");
		for(FieldError err : e.getBindingResult().getFieldErrors())
		{
			error.addErrors(err.getField(), e.getLocalizedMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
		StringBuilder message2 = new StringBuilder();
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
	    for (ConstraintViolation<?> violation : violations) {
	      message2.append(violation.getPropertyPath().toString().toUpperCase().concat(" ").concat(violation.getMessage().toUpperCase().concat(" ")));
	    }

		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), message2.toString());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}
	
	
}
