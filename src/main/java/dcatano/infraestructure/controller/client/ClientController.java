package dcatano.infraestructure.controller.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.ClientRepository;
import dcatano.domain.client.Constants;
import dcatano.domain.client.Validation;
import dcatano.infraestructure.controller.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "client")
@RequiredArgsConstructor
public class ClientController {
	private final ClientRepository clientRepository;
	@PostMapping()
	public ResponseEntity<Response> createClient(@RequestBody ClientDTO client) {
		Client client1 = client.toDomain();
		Validation validation = client1.isValid();
		if(validation.isValid()) {
			clientRepository.save(client1);
			return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Constants.CLIENT_CREATED));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(validation.getMessage()));
	}
}
