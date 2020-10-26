import java.util.Scanner;

public class DataValidationApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Area and Perimeter Calculator");

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		// prompt user for length
		while (choice.equalsIgnoreCase("y")) {

			double length = getDoubleWithinRange(sc, "Enter length: ", 0.0, 1000000.0);

			// prompt user for width
			double width = getDoubleWithinRange(sc, "Enter width: ", 0.0, 1000000.0);

			// business logic
			double area = length * width;
			double perimeter = (length * 2) + (width * 2);
			// print results
			System.out.println("Area " + area);
			System.out.println("Perimeter " + perimeter);
			// prompt user to continue
			choice = userContinue(sc, "Continue? (y/n): ", "y", "n");
		} // if yes go back to beginning

		// if no, goodbye
	}

	// validate input
	private static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max) {
		boolean isValid = false;
		double input = 0;
		while (isValid != true) {
			System.out.println(prompt);
			try {
				input = sc.nextDouble();
			} catch (Exception e) {
				System.out.println("Error! Invalid decimal value. Try again.");
				break;
			}

			if (input <= min) {
				System.out.println("Error! Number must be greater than " + min);
				continue;
			}

			if (input >= max) {
				System.out.println("Error! Number must be less than " + max);
				continue;
			}
			isValid = true;
		}

		return input;
	}

	public static String userContinue(Scanner sc, String prompt, String value1, String value2) {

		String s = "";
		while (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2)) {

			System.out.print(prompt);
			s = sc.next();
			if (s.length() == 0) {
				System.out.println("Error! This entry is required. Try again.");
			} else if (!s.equalsIgnoreCase(value1) && !s.equalsIgnoreCase(value2)) {
				System.out.println("Error! Entry must be " + value1 + " or " + value2 + ". Try agian.");
			} else if (s.equalsIgnoreCase(value1) && s.equalsIgnoreCase(value2)) {
				System.out.println("Continue? (y/n): ");
			}

		}
		return s;

	}
}
