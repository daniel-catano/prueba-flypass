package dcatano.domain.client.product;

import dcatano.exception.NoDataFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository {
	Optional<Product> findLast();

	void save(Product product, Long clientId) throws NoDataFoundException;
}
