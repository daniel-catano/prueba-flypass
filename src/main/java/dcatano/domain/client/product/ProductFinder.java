package dcatano.domain.client.product;

import dcatano.infraestructure.database.client.DBPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFinder {
	private final ProductRepository productRepository;

	public DBPage<Product> find(Integer pageSize, Integer page, Long clientId) {
		DBPage<Product> result = productRepository.findAllByClientIdPaginated(page, pageSize, clientId);
		return new DBPage<>(result.getResults().stream().toList(), result.getTotalPages());
	}
}
