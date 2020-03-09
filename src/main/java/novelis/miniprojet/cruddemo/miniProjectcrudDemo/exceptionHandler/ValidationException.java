package novelis.miniprojet.cruddemo.miniProjectcrudDemo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Could not add the Collaborator";

	public ValidationException(String exception) {
        super(exception);
    }
	public ValidationException() {
        super(String.format(MESSAGE));
    }
}
