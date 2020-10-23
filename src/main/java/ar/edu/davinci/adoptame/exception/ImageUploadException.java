package ar.edu.davinci.adoptame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Ha ocurrido un error al subir la imagen")

public class ImageUploadException extends RuntimeException {


	private static final long serialVersionUID = 681464480248197371L;

}
