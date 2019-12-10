package cn.com.trueway.sys.service.exception;

public class UsernameNotFoundException extends ServiceException {

	private static final long serialVersionUID = 6190577024562206571L;

	public UsernameNotFoundException() {
		super();
	}

	public UsernameNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameNotFoundException(String message) {
		super(message);
	}

	public UsernameNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
