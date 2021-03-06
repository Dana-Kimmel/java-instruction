package kimmel.ui;

import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);

	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	// overloaded method
	public static String getString(String prompt, String value1, String value2) {
		String s;
		System.out.print(prompt);
		s = sc.nextLine(); // read user entry
		while (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2)) {
			System.out.println("Error! Entry must be " + value1 + " or " + value2 + ". Try again.");
			s = sc.next();

		}
		return s;

	}

	public static String getString2(String prompt, String allowedValOne, String allowedValTwo) {
		String value = "";
		boolean isValid = false;
		while (!isValid) {
			value = getString(prompt);
			if (value.equalsIgnoreCase(allowedValOne) || value.equalsIgnoreCase(allowedValTwo)) {
				isValid = true;
			} else {
				System.out.println("Invalid entry. Please enter " + allowedValOne + " or " + allowedValTwo);
			}
		}
		return value;
	}

	public static int getInt(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt(prompt);
			if (i <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (i >= max) {
				System.out.println("Error! Number must be less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return i;
	}

	public static double getDouble(String prompt) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid number. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			d = getDouble(prompt);
			if (d <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (d >= max) {
				System.out.println("Error! Number must be less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return d;
	}
}