package novelis.miniprojet.cruddemo.miniProjectcrudDemo.pagination;

public class ErrorResponse extends AppResponse {
	
	 public ErrorResponse(String errorMessage) {
	        super(false);
	        addFullMessage(errorMessage);
	    }
}
