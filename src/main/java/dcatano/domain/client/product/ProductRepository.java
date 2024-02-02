package dcatano.domain.client.product;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository {
	Optional<Product> findLast();
}
