package dcatano.domain.client;

import dcatano.utils.DateUtils;
import dcatano.utils.StringUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Client {
	private final Long id;
	private final Identification identification;
	private final String names;
	private final String lastnames;
	private final String email;
	private final Date birthdate;
	private final Date creationDate;

	public Validation isValid() {
		if(isUnderAge()) {
			return new Validation(false, Constants.PERSON_UNDER_AGE);
		}
		if(invalidNames()) {
			return new Validation(false, Constants.INVALID_NAMES);
		}
		if(!StringUtils.validEMailPattern(email)) {
			return new Validation(false, Constants.INVALID_EMAIL);
		}
		return new Validation(true, Constants.VALID_PERSON);
	}

	private boolean invalidNames() {
		return names.length() < Constants.NAMES_MIN_LENGTH || lastnames.length() < Constants.NAMES_MIN_LENGTH;
	}

	private boolean isUnderAge() {
		return DateUtils.getDateDiff(birthdate, new Date()) < Constants.UNDER_AGE;
	}
}
