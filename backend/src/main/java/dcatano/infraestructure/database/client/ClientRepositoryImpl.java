package dcatano.infraestructure.database.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
	private final DBClientRepository dbClientRepository;

	@Override
	public void save(Client client) {
		dbClientRepository.save(DBClient.fromDomain(client));
	}

	@Override
	public DBPage<Client> findAllPaginated(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<DBClient> result = dbClientRepository.findAll(pageable);
		return new DBPage<>(
				result.getContent().stream().map(DBClient::toDomain).toList(),
				result.getTotalPages()
		);
	}


}
