package ar.com.fravega.fravegaChallenge.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = -4106339686576760177L;

	public BadRequestException(String message) {
		super(message);
	}
}
