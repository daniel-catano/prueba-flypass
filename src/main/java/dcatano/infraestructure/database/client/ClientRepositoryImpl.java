package dcatano.infraestructure.database.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ProductRepository {
	private final DBClientRepository dbClientRepository;
	@Override
	public Optional<Client> findLast() {
		return Optional.ofNullable(dbClientRepository.findTopOneByDesc()).map(DBClient::toDomain);
	}
}
