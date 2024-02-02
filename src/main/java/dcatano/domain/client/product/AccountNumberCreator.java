package dcatano.domain.client.product;

import dcatano.domain.client.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountNumberCreator {
	private final ProductRepository productRepository;
	protected String createAccountNumber(ProductType productType) {
		return String.format("%s%s", productType.getPrefix(), generateNewAccountNumber());
	}

	private String generateNewAccountNumber() {
		long productNumber = productRepository.findLast().map(Product::getAccountNumber).map(a -> a.substring(2)).map(Long::parseLong).orElse(0L);
		long nextNumber = productNumber + 1;
		String nextNumberAsString = String.valueOf(nextNumber);
		return String.format("%s%s", "0".repeat(Constants.ACCOUNT_NUMBER_LENGTH_WITHOUT_PREFIX - nextNumberAsString.length()), nextNumberAsString);
	}
}
