package dcatano.domain.client.product;

import dcatano.domain.client.Constants;
import dcatano.exception.LenghExceededException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@AllArgsConstructor
public class ProductFactory {
	private final AccountNumberCreator accountNumberCreator;
	public Product createSavingAccount(BigDecimal balance, boolean gfmExcept) throws LenghExceededException {
		return new Product(
			null,
			ProductType.SAVING_ACCOUNT,
			createAccountNumber(ProductType.SAVING_ACCOUNT),
			balance,
			gfmExcept,
			new Date()
		);
	}

	public Product createCurrentAccount(BigDecimal balance, boolean gfmExcept) throws LenghExceededException {
		return new Product(
			null,
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
