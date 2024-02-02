package dcatano.infraestructure.database.client.product;

import dcatano.domain.client.product.Product;
import dcatano.domain.client.product.ProductRepository;
import dcatano.exception.NoDataFoundException;
import dcatano.infraestructure.database.client.DBClient;
import dcatano.infraestructure.database.client.DBClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
	private final DBProductRepository dbProductRepository;
	private final DBClientRepository dbClientRepository;
	@Override
	public Optional<Product> findLast() {
		return Optional.ofNullable(dbProductRepository.findTopOneByOrderByIdDesc()).map(DBProduct::toDomain);
	}

	@Override
	public void save(Product product, Long clientId) throws NoDataFoundException {
		DBClient client = dbClientRepository.findById(clientId).orElseThrow(NoDataFoundException::new);
		dbProductRepository.save(DBProduct.fromDomain(product, client));
	}
}
