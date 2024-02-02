package dcatano.infraestructure.controller.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.Identification;
import dcatano.domain.client.IdentificationType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClientDTO {
	private IdentificationType type;
	private String number;
	private String names;
	private String lastNames;
	private String email;
	private Long birthdate;

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
