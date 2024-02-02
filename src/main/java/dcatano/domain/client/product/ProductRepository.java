package dcatano.domain.client.product;

import java.util.Optional;

public interface ProductRepository {
	Optional<Product> findLast();
}
