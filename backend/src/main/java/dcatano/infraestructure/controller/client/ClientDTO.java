package dcatano.infraestructure.controller.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.Identification;
import dcatano.domain.client.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
	private Long id;
	private IdentificationType type;
	private String number;
	private String names;
	private String lastNames;
	private String email;
	private Long birthdate;

	public static ClientDTO fromDomain(Client client) {
		return new ClientDTO(
			client.getId(),
			client.getIdentification().getType(),
			client.getIdentification().getNumber(),
			client.getNames(),
			client.getLastnames(),
			client.getEmail(),
			client.getBirthdate().getTime()
		);
	}

	public Client toDomain() {
		return new Client(
			null,
			new Identification(type, number),
			names,
			lastNames,
			email,
			new Date(birthdate),
			new Date()
		);
	}
}
