package dcatano.exception;

import dcatano.domain.client.Constants;

public class NoDataFoundException extends Exception {
	public NoDataFoundException() {
		super(Constants.NO_DATA_FOUND);
	}
}
