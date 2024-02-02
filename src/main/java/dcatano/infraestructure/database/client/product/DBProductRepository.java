package dcatano.infraestructure.database.client.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBProductRepository extends CrudRepository<DBProduct, Long>, PagingAndSortingRepository<DBProduct, Long> {
	DBProduct findTopOneByOrderByIdDesc();
}
