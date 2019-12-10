package cn.com.trueway.sys.service.exception;

public class IllegalParamException extends ServiceException {

	private static final long serialVersionUID = 6964004548274518555L;

	public IllegalParamException() {
		super();
		
	}

	public IllegalParamException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public IllegalParamException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public IllegalParamException(String message) {
		super(message);
	
	}

	public IllegalParamException(Throwable cause) {
		super(cause);
		
	}
	
}
