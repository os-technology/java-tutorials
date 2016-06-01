/**
 * 
 */
package com.eccl.product.liujian.tutorials.io;

import java.io.Console;
import java.util.Arrays;

/**
 * @author LiuJian
 * 
 */
public class Password {
	public final static String LOGIN_USER = "admin";
	public final static String PASSWORD = "1234";

	public static void main(String args[]) {
		Console c = System.console();
		if (c == null) {
			System.err.println("No console.");
			System.exit(1);
		} else {
			String login = c.readLine("Enter your login: ");
			char[] oldPassword = c.readPassword("Enter your old password: ");

			if (verify(login, oldPassword)) {
				boolean noMatch;
				do {
					char[] newPassword1 = c
							.readPassword("Enter your new password: ");
					char[] newPassword2 = c
							.readPassword("Enter new password again: ");
					noMatch = !Arrays.equals(newPassword1, newPassword2);
					if (noMatch) {
						c.format("Passwords don't match. Try again.%n");
					} else {
						change(login, newPassword1);
						c.format("Password for %s changed.%n", login);
					}
					Arrays.fill(newPassword1, ' ');
					Arrays.fill(newPassword2, ' ');
				} while (noMatch);
			}

			Arrays.fill(oldPassword, ' ');
		}
	}

	// Dummy change method.
	static boolean verify(String login, char[] password) {
		// This method always returns
		// true in this example.
		// Modify this method to verify
		// password according to your rules.
		if (LOGIN_USER.equalsIgnoreCase(login)
				&& PASSWORD.equalsIgnoreCase(new String(password)))
			return true;

		return false;
	}

	// Dummy change method.
	static void change(String login, char[] password) {
		// Modify this method to change
		// password according to your rules.
		if (LOGIN_USER.equalsIgnoreCase(login)
				&& PASSWORD.equalsIgnoreCase(new String(password)))
			return;
	}
}
