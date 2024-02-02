package dcatano.domain.client.product;

import dcatano.exception.NoDataFoundException;
import dcatano.infraestructure.database.client.DBPage;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository {
	Optional<Product> findLast();

	void save(Product product, Long clientId) throws NoDataFoundException;

	DBPage<Product> findAllPaginated(int page, int pageSize);
}
