//Katie Sullivan

package LayOut;

public class PasswordAuthentication {

	public static boolean authenticate(String username, String password) {
		// hardcoded for testing
		if (username.equals("katie") && password.equals("password")) {
			return true;
		}
		return false;
	}

}
