package dcatano.utils;

import java.util.regex.Pattern;

public class StringUtils {
	private StringUtils(){}

	public static boolean validEMailPattern(String emailAddress) {
		String numberOrLetters = "(\\.[A-Za-z0-9-]+)*";
		String regexPattern = String.format("^(?=.{1,64}@)[A-Za-z0-9_-]+%s@[^-][A-Za-z0-9-]+%s(\\.[A-Za-z]{2,})$", numberOrLetters, numberOrLetters);
		return Pattern.compile(regexPattern)
				.matcher(emailAddress)
				.matches();
	}
}
