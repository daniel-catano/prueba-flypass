package dcatano.domain;

import dcatano.domain.client.Client;
import dcatano.domain.client.Constants;
import dcatano.domain.client.Identification;
import dcatano.domain.client.IdentificationType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {
	private static Date date;
	@BeforeAll
	static void init() {
		LocalDate localDate = LocalDate.now().minusYears(20);
		date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	@Test
	void shouldBeInvalidAge() {
		Client client = new Client(
		1L,
			new Identification(IdentificationType.IDENTIFICATION_CARD, "123"),
		"Daniel",
			"Cataño",
			"dcatanor@gmail.com",
			new Date(),
			new Date()
		);
		assertEquals(Constants.PERSON_UNDER_AGE, client.isValid().getMessage());
	}

	@Test
	void shouldBeInvalidOnNameLengthOf1() {
		Client client = new Client(
				1L,
				new Identification(IdentificationType.IDENTIFICATION_CARD, "123"),
				"D",
				"Cataño",
				"dcatanor@gmail.com",
				date,
				new Date()
		);
		assertEquals(Constants.INVALID_NAMES, client.isValid().getMessage());
	}

	@Test
	void shouldBeInvalidOnLastNameLengthOf1() {
		Client client = new Client(
				1L,
				new Identification(IdentificationType.IDENTIFICATION_CARD, "123"),
				"Daniel",
				"C",
				"dcatanor@gmail.com",
				date,
				new Date()
		);
		assertEquals(Constants.INVALID_NAMES, client.isValid().getMessage());
	}

	@Test
	void shouldBeInvalidEmail() {
		Client client = new Client(
				1L,
				new Identification(IdentificationType.IDENTIFICATION_CARD, "123"),
				"Daniel",
				"Cataño",
				"dcatanor@gmail",
				date,
				new Date()
		);
		assertEquals(Constants.INVALID_EMAIL, client.isValid().getMessage());
	}
	@Test
	void shouldBeValidClient() {
		Client client = new Client(
				1L,
				new Identification(IdentificationType.IDENTIFICATION_CARD, "123"),
				"Daniel",
				"Cataño",
				"dcatanor@gmail.com",
				date,
				new Date()
		);
		assertTrue(client.isValid().isValid());
	}


}
