package dcatano.infraestructure.database.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl {
	private final DBClientRepository dbClientRepository;
}
