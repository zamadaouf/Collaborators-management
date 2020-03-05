package novelis.miniprojet.cruddemo.miniProjectcrudDemo.exceptionHandler;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.servlet.NoHandlerFoundException;
 
@XmlRootElement(name = "error")
public class ErrorResponse {
	
    //General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;

    
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
 
//    public ErrorResponse(Throwable ex) {
//        super();
//        this.message = ex;
//    }

    
    //Getter and setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}



	@Override
	public String toString() {


		return "ErrorResponse [message=" + message + ",\n details=" + details + "]";
	}

    
}
