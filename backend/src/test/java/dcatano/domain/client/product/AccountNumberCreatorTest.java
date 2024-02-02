package dcatano.domain.client.product;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class AccountNumberCreatorTest {
	private final ProductRepository productRepository = mock(ProductRepository.class);
	private final AccountNumberCreator accountNumberCreator = new AccountNumberCreator(productRepository);

	@Test
	void shouldCreateSavingAccount() {
		Mockito.when(productRepository.findLast()).thenReturn(Optional.empty());
		String accountNumber = accountNumberCreator.createAccountNumber(ProductType.SAVING_ACCOUNT);
		assertEquals(String.format("%s00000001", ProductType.SAVING_ACCOUNT.getPrefix()), accountNumber);
	}

	@Test
	void shouldCreateSavingAccountWithAnAlreadyExistenAccount() {
		Mockito.when(productRepository.findLast()).thenReturn(Optional.of(new Product(
			1L,
			ProductType.SAVING_ACCOUNT,
			String.format("%s11111111", ProductType.SAVING_ACCOUNT.getPrefix()),
			ProductStatus.ACTIVE,
			BigDecimal.TEN,
			true,
			new Date()
		)));
		String accountNumber = accountNumberCreator.createAccountNumber(ProductType.SAVING_ACCOUNT);
		assertEquals(String.format("%s11111112", ProductType.SAVING_ACCOUNT.getPrefix()), accountNumber);
	}

	@Test
	void shouldCreateCurrentAccount() {
		Mockito.when(productRepository.findLast()).thenReturn(Optional.empty());
		String accountNumber = accountNumberCreator.createAccountNumber(ProductType.CURRENT_ACCOUNT);
		assertEquals(String.format("%s00000001", ProductType.CURRENT_ACCOUNT.getPrefix()), accountNumber);
	}

	@Test
	void shouldCurrentSavingAccountWithAnAlreadyExistenAccount() {
		Mockito.when(productRepository.findLast()).thenReturn(Optional.of(new Product(
			1L,
			ProductType.SAVING_ACCOUNT,
			String.format("%s12345678", ProductType.CURRENT_ACCOUNT.getPrefix()),
			ProductStatus.ACTIVE,
			BigDecimal.TEN,
			true,
			new Date()
		)));
		String accountNumber = accountNumberCreator.createAccountNumber(ProductType.CURRENT_ACCOUNT);
		assertEquals(String.format("%s12345679", ProductType.CURRENT_ACCOUNT.getPrefix()), accountNumber);
	}
}
