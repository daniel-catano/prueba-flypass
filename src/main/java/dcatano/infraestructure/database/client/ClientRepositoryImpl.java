package dcatano.infraestructure.database.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
	private final DBClientRepository dbClientRepository;

	@Override
	public void save(Client client) {
		dbClientRepository.save(DBClient.fromDomain(client));
	}
}
