package novelis.miniprojet.cruddemo.miniProjectcrudDemo.exceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		List<String> details = new ArrayList<>();

		Set<ConstraintViolation<?>> violations = ((ConstraintViolationException) ex).getConstraintViolations();
	
		for (ConstraintViolation<?> violation : violations) {
	
			details.add(violation.getMessage());
		}
	
		ErrorResponse error = new ErrorResponse("Validation Error", details);
	
			return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}	

}
//@ControllerAdvice
//public class CustomExceptionHandler {
//
//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public @ResponseBody ResponseEntity<ErrorResponse> handleNoMethodException(HttpServletRequest request,
//            NoHandlerFoundException ex) {
//        ErrorResponse errorResponse = new ErrorResponse(ex);
//        errorResponse.setMessage("resource not found with exception");
//        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Throwable.class)
//    public @ResponseBody ResponseEntity<ErrorResponse> handleDefaultException(Throwable ex) {
//        ErrorResponse errorResponse = new ErrorResponse(ex);
//        errorResponse.setMessage("request has empty body  or exception occured");
//        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//}
