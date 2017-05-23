package res;

import java.util.regex.Pattern;

public class Constants {
	public static String go = "Iniciar sesion";
	public static Pattern CONSTRAINT_CONTRASENIA = Pattern.compile("^[0-9]{1,4}$");
	public static Pattern REGEX_MATRICULA = Pattern
			.compile("^([A-Z]{1,2})([0-9]{4})([A-Z]{1,2})$|^([0-9]{4})([A-Z]{3})$");
}
