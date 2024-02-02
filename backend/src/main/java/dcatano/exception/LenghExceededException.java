package dcatano.exception;

import dcatano.domain.client.Constants;

public class LenghExceededException extends Exception {
	public LenghExceededException() {
		super(Constants.LENGTH_EXCEED_MESSAGE);
	}
}
