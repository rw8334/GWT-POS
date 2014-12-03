package web.prog.shared;

/**
 * <p>
 * LoginVerifier validates that the username and password the user enters is valid.
 */
public class LoginVerifier {

	/**
	 * Verifies that the specified username and password is valid
	 * @param username the name to validate
	 * @return true if valid, false if invalid
	 */
	public static boolean areCredentialsGood(String name, String password) {
		return name.equals("username") && password.equals("password");
	}
}
