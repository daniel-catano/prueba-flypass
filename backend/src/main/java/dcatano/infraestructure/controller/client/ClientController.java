package dcatano.infraestructure.controller.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.ClientFinder;
import dcatano.domain.client.ClientRepository;
import dcatano.domain.client.Constants;
import dcatano.domain.client.Validation;
import dcatano.domain.client.product.Product;
import dcatano.domain.client.product.ProductFactory;
import dcatano.domain.client.product.ProductFinder;
import dcatano.domain.client.product.ProductRepository;
import dcatano.exception.LenghExceededException;
import dcatano.exception.NoDataFoundException;
import dcatano.infraestructure.controller.PaginatedResponse;
import dcatano.infraestructure.controller.Response;
import dcatano.infraestructure.database.client.DBPage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClientController {
	private final ClientRepository clientRepository;
	private final ClientFinder clientFinder;
	private final ProductFactory productFactory;
	private final ProductRepository productRepository;
	private final ProductFinder productFinder;

	@PostMapping()
	public ResponseEntity<Response> createClient(@RequestBody ClientDTO client) {
		Client client1 = client.toDomain();
		Validation validation = client1.isValid();
		if (validation.isValid()) {
			clientRepository.save(client1);
			return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Constants.CLIENT_CREATED));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(validation.getMessage()));
	}

	@GetMapping()
	public ResponseEntity<PaginatedResponse<ClientDTO>> listClients(
		@RequestParam(defaultValue = "20") String pageSize,
		@RequestParam(defaultValue = "0") String page
	) {
		DBPage<ClientDTO> clientPage = clientFinder.find(Integer.parseInt(pageSize), Integer.parseInt(page));
		return ResponseEntity.ok(new PaginatedResponse<>(clientPage.getResults(), clientPage.getTotalPages()));
	}

	@PostMapping("/{client_id}")
	public ResponseEntity<Response> saveProduct(
			@PathVariable(name = "client_id") String clientId,
			@RequestBody ProductDTO productDTO
	) throws NoDataFoundException, LenghExceededException {
		Product product = productFactory.createSavingAccount(productDTO.getBalance(), productDTO.isGfmExcept());
		productRepository.save(product, Long.parseLong(clientId));
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Constants.PRODUCT_CREATED));
	}

	@GetMapping("/{client_id}/products")
	public ResponseEntity<PaginatedResponse<Product>> listProducts(
			@PathVariable(name = "client_id") Long clientId,
			@RequestParam(defaultValue = "20") Integer pageSize,
			@RequestParam(defaultValue = "0") Integer page
	) {
		DBPage<Product> clientPage = productFinder.find(pageSize, page, clientId);
		return ResponseEntity.ok(new PaginatedResponse<>(clientPage.getResults(), clientPage.getTotalPages()));
	}
}
