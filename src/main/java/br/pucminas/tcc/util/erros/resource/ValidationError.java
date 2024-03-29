package br.pucminas.tcc.util.erros.resource;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> errors = new ArrayList<FieldMessage>();
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Integer status, Long timestamp, String message) {
		super(status, timestamp, message);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
