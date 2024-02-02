package dcatano.domain.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Validation {
	private final boolean valid;
	private final String message;
}
