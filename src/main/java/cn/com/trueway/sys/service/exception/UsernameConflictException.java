package cn.com.trueway.sys.service.exception;

public class UsernameConflictException extends ServiceException {

	private static final long serialVersionUID = 3041501410320953478L;

	public UsernameConflictException() {
		super();
	}

	public UsernameConflictException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameConflictException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameConflictException(String message) {
		super(message);
	}

	public UsernameConflictException(Throwable cause) {
		super(cause);
	}

}
