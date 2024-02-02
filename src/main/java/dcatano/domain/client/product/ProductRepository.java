package dcatano.domain.client.product;

import dcatano.domain.client.Client;

import java.util.Optional;

public interface ProductRepository {
	Optional<Client> findLast();
}
