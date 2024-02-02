package dcatano.infraestructure.database.client.product;

import dcatano.domain.client.product.Product;
import dcatano.domain.client.product.ProductRepository;
import dcatano.exception.NoDataFoundException;
import dcatano.infraestructure.database.client.DBClient;
import dcatano.infraestructure.database.client.DBClientRepository;
import dcatano.infraestructure.database.client.DBPage;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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

	@Override
	public DBPage<Product> findAllByClientIdPaginated(int page, int pageSize, Long clientId) {
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<DBProduct> result = dbProductRepository.findAll(getSpecification(clientId), pageable);
		return new DBPage<>(
				result.getContent().stream().map(DBProduct::toDomain).toList(),
				result.getTotalPages()
		);
	}

	private Specification<DBProduct> getSpecification(Long clientId) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(cb.equal(root.get("client").get("id"), clientId));
			return cb.and(predicates.toArray(new Predicate[]{}));
		};
	}
}
