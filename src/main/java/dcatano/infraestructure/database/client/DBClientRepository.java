package dcatano.infraestructure.database.client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBClientRepository extends CrudRepository<DBClient, Long> {
}
