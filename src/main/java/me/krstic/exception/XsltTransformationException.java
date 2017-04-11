package me.krstic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error in performing XSLT transformation on input data.")
public class XsltTransformationException extends RuntimeException {
	private static final long serialVersionUID = 1L; 
}
