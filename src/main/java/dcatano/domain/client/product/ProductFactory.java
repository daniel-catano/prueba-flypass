package dcatano.domain.client.product;

import dcatano.domain.client.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@AllArgsConstructor
public class ProductFactory {
	private final AccountNumberCreator accountNumberCreator;
	public Product createSavingAccount(Long id, BigDecimal balance, boolean gfmExcept) throws LenghExceededException {
		return new Product(
			id,
			ProductType.SAVING_ACCOUNT,
			createAccountNumber(ProductType.SAVING_ACCOUNT),
			balance,
			gfmExcept,
			new Date()
		);
	}

	public Product createCurrentAccount(Long id, BigDecimal balance, boolean gfmExcept) throws LenghExceededException {
		return new Product(
			id,
			ProductType.CURRENT_ACCOUNT,
			createAccountNumber(ProductType.CURRENT_ACCOUNT),
			balance,
			gfmExcept,
			new Date()
		);
	}

	private String createAccountNumber(ProductType productType) throws LenghExceededException {
		String accountNumber = accountNumberCreator.createAccountNumber(productType);
		if(accountNumber.length() > Constants.MAX_ACCOUNT_LENGTH) {
			throw new LenghExceededException();
		}
		return accountNumber;
	}
}
