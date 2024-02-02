package dcatano.infraestructure.database.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.Identification;
import dcatano.domain.client.IdentificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class DBClient {
	private Long id;
	@Enumerated
	private IdentificationType type;
	private String number;
	private String names;
	private String lastnames;
	private String email;
	private Date birthdate;
	private Date creationDate;

	public Client toDomain() {
		return new Client(
			id,
			new Identification(type, number),
			names,
			lastnames,
			email,
			birthdate,
			creationDate
		);
	}
}
