package dcatano.infraestructure.database.client.product;

import dcatano.domain.client.Client;
import dcatano.domain.client.product.Product;
import dcatano.domain.client.product.ProductStatus;
import dcatano.domain.client.product.ProductType;
import dcatano.infraestructure.database.client.DBClient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DBProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated
	@Column(name = "product_type")
	private ProductType productType;
	@Column(name = "account_number")
	private String accountNumber;
	@Enumerated
	@Column(name = "_status")
	private ProductStatus status;
	private BigDecimal balance;
	@Column(name = "gfm_exempt")
	private boolean gfmExempt;
	@Column(name = "creation_date")
	private Date creationDate;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "client_id")
	private DBClient client;

	public static DBProduct fromDomain(Product product, DBClient client) {
		return new DBProduct(
			product.getId(),
			product.getProductType(),
			product.getAccountNumber(),
			product.getStatus(),
			product.getBalance(),
			product.isGfmExempt(),
			product.getCreationDate(),
			client
		);
	}

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
