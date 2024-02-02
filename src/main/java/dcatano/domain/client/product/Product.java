package dcatano.domain.client.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@AllArgsConstructor
public class Product {
	private final Long id;
	private final ProductType productType;
	private final String accountNumber;
	private final ProductStatus status;
	private final BigDecimal balance;
	private final boolean gfmExempt;
	private final Date creationDate;

	protected Product(Long id, ProductType productType, String accountNumber, BigDecimal balance, boolean gfmExempt, Date creationDate) {
		this.id = id;
		this.productType = productType;
		this.accountNumber = accountNumber;
		this.status = ProductStatus.ACTIVE;
		this.balance = balance;
		this.gfmExempt = gfmExempt;
		this.creationDate = creationDate;
	}
}
