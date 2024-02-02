package dcatano.domain.client;

import java.util.Random;

public class Constants {
	public static final int NAMES_MIN_LENGTH = 2;
	public static final String INVALID_NAMES = "El nombre y el apellido deben tener una longitud mayor a dos caracteres";
	public static final String INVALID_EMAIL = "Correo inválido.";
	public static final Random RANDOM = new Random();
	public static final int ACCOUNT_NUMBER_LENGTH_WITHOUT_PREFIX = 8;
	public static final int MAX_ACCOUNT_LENGTH = 10;
	public static final String LENGTH_EXCEED_MESSAGE = "No se puede crear un número de cuenta con más de 10 dígitos";

	private Constants(){}
	public static final int UNDER_AGE = 18;
	public static final String PERSON_UNDER_AGE = "La persona es menor de edad.";
	public static final String VALID_PERSON = "Persona válida";
}
