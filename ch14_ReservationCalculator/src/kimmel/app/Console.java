package kimmel.app;

import java.time.LocalDate;
import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);

	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine(); // read user entry
		// sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	// Overloaded getString Method
	public static String getString(String prompt, String value1, String value2) {
		String s = "";
		while (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2)) {

			System.out.print(prompt);
			s = sc.nextLine(); // read user entry
			if (s.trim().isEmpty()) {
				System.out.println("Error! This entry is required. Try again.");
			} else if (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2)) {
				System.out.println("Error! Entry must be 'y' or 'n'. Try agian.");
			} else if (s.equalsIgnoreCase(value1) && s.equalsIgnoreCase(value2)) {
				System.out.println("Continue? (y/n): ");
			}

		}
		return s;
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

	public static LocalDate getLocalDate(String dateName) {
		int month = Console.getInt("Enter the " + dateName + " month (1-12): ", 0, 13);
		int day = Console.getInt("Enter the " + dateName + " day (1-31): ", 0, 32);
		int year = Console.getInt("Enter the " + dateName + " year: ", 2019, 2200);
		System.out.println();
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}
}