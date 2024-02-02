package dcatano.domain.client;

import dcatano.infraestructure.database.client.DBPage;

public interface ClientRepository {
	void save(Client client);
	DBPage<Client> findAllPaginated(int page, int pageSize);
}
