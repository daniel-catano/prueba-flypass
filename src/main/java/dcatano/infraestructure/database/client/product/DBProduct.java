package dcatano.infraestructure.database.client.product;

import dcatano.domain.client.product.Product;
import dcatano.domain.client.product.ProductStatus;
import dcatano.domain.client.product.ProductType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "product")
@Getter
@Setter
public class DBProduct {
	@Id
	private Long id;
	@Enumerated
	private ProductType productType;
	private String accountNumber;
	@Enumerated
	private ProductStatus status;
	private BigDecimal balance;
	private boolean gfmExempt;
	private Date creationDate;

	public Product toDomain() {
		return new Product(
			id,
			productType,
			accountNumber,
			status,
			balance,
			gfmExempt,
			creationDate
		);
	}
}
