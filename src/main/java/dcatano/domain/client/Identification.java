package dcatano.domain.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Identification {
	private final IdentificationType type;
	private final String number;
}
