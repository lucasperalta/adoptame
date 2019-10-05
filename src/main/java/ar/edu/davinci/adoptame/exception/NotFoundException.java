package ar.edu.davinci.adoptame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No encontrado")

public class NotFoundException extends RuntimeException {


	private static final long serialVersionUID = 681464480248197371L;

}
