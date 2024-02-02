package dcatano.domain.client;

import dcatano.infraestructure.controller.client.ClientDTO;
import dcatano.infraestructure.database.client.DBPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientFinder {
	private final ClientRepository clientRepository;
	public DBPage<ClientDTO> find(int pageSize, int page) {
		DBPage<Client> result = clientRepository.findAllPaginated(page, pageSize);
		return new DBPage<>(result.getResults().stream().map(ClientDTO::fromDomain).toList(), result.getTotalPages());
	}
}
