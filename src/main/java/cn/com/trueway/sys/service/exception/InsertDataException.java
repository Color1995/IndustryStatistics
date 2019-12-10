package cn.com.trueway.sys.service.exception;

public class InsertDataException extends ServiceException {

	private static final long serialVersionUID = 6859320337573820168L;

	public InsertDataException() {
		super();
	}

	public InsertDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsertDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsertDataException(String message) {
		super(message);
	}

	public InsertDataException(Throwable cause) {
		super(cause);
	}

	
}
