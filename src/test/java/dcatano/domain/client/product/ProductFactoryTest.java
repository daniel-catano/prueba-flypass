package dcatano.domain.client.product;

import dcatano.exception.LenghExceededException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class ProductFactoryTest {
	private final AccountNumberCreator accountNumberCreator = mock(AccountNumberCreator.class);
	private final ProductFactory productFactory = new ProductFactory(accountNumberCreator);
	@Test
	void shouldCreateASavingAccount() throws LenghExceededException {
		Mockito.when(accountNumberCreator.createAccountNumber(Mockito.any(ProductType.class))).thenReturn("23111111");
		assertEquals(ProductType.SAVING_ACCOUNT, productFactory.createSavingAccount(BigDecimal.TEN, true).getProductType());
	}

	@Test
	void shouldCreateACurrentAccount() throws LenghExceededException {
		Mockito.when(accountNumberCreator.createAccountNumber(Mockito.any(ProductType.class))).thenReturn("23111111");
		assertEquals(ProductType.CURRENT_ACCOUNT, productFactory.createCurrentAccount(BigDecimal.TEN, true).getProductType());
	}

	@Test
	void shouldThrowOnLimitExceeded() throws LenghExceededException {
		Mockito.when(accountNumberCreator.createAccountNumber(Mockito.any(ProductType.class))).thenReturn("23444444444");
		assertThrows(LenghExceededException.class, () -> productFactory.createCurrentAccount(BigDecimal.TEN, true));
	}
}
