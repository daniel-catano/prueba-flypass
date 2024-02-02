package dcatano.infraestructure.database.client.product;

import dcatano.domain.client.product.Product;
import dcatano.domain.client.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
	private final DBProductRepository dbProductRepository;
	@Override
	public Optional<Product> findLast() {
		return Optional.ofNullable(dbProductRepository.findTopOneByOrderByIdDesc()).map(DBProduct::toDomain);
	}
}
