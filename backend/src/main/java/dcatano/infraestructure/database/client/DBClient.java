package dcatano.infraestructure.database.client;

import dcatano.domain.client.Client;
import dcatano.domain.client.Identification;
import dcatano.domain.client.IdentificationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class DBClient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated
	@Column(name = "_type")
	private IdentificationType type;
	@Column(name = "_number")
	private String number;
	@Column(name = "_names")
	private String names;
	private String lastnames;
	private String email;
	private Date birthdate;
	private Date creationDate;

	public DBClient(IdentificationType type, String number, String names, String lastnames, String email, Date birthdate, Date creationDate) {
		this.type = type;
		this.number = number;
		this.names = names;
		this.lastnames = lastnames;
		this.email = email;
		this.birthdate = birthdate;
		this.creationDate = creationDate;
	}

	public static DBClient fromDomain(Client client) {
		return new DBClient(
			client.getIdentification().getType(),
			client.getIdentification().getNumber(),
			client.getNames(),
			client.getLastnames(),
			client.getEmail(),
			client.getBirthdate(),
			client.getCreationDate()
		);
	}

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
