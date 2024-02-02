package dcatano.infraestructure.database.client.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBProductRepository extends CrudRepository<DBProduct, Long> {
	DBProduct findTopOneByOrderByIdDesc();
}
