package dcatano.domain.client.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductType {
	CURRENT_ACCOUNT("46"),
	SAVING_ACCOUNT("23"),
	;

	private final String prefix;
}
