package novelis.miniprojet.cruddemo.miniProjectcrudDemo.pagination;

public class SuccessResponse extends AppResponse{
	
	public SuccessResponse(String message) {
        super(true);
        addFullMessage(message);
    }

    public SuccessResponse() {
        this(null);
    }

}
