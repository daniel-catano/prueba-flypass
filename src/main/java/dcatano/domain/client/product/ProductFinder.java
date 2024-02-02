package dcatano.domain.client.product;

import dcatano.infraestructure.database.client.DBPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFinder {
	private final ProductRepository productRepository;

	public DBPage<Product> find(int pageSize, int page) {
		DBPage<Product> result = productRepository.findAllPaginated(page, pageSize);
		return new DBPage<>(result.getResults().stream().toList(), result.getTotalPages());
	}
}
