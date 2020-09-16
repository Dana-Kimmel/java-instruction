import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueWithMethodApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (!choice.equalsIgnoreCase("n")) {
			// get the input from the user
			double monthlyInvestment;
			double interestRate;
			int years;

			monthlyInvestment = getDoubleWithinRange(sc, "Enter monthly investment:   ", 0, 1000);
			interestRate = getDoubleWithinRange(sc, "Enter yearly interest rate: ", 0, 30);
			years = getIntWithinRange(sc, "Enter number of years: ", 0, 100);

			// convert yearly values to monthly values
			double monthlyInterestRate = interestRate / 12 / 100;
			int months = years * 12;

			// call the future value method
			System.out.println("About to call calculateFutureValue");
			double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

			// format and display the result
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			System.out.println("Future value:               " + currency.format(futureValue));
			System.out.println();

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}

	public static double calculateFutureValue(double monthlyInvestment, double monthlyInterestRate, int months) {
		System.out.println("IncalculateFutureValue");
		double futureValue = 0.0;

		for (int i = 1; i <= months; i++) {
			futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
		}
		return futureValue;
	}

	public static double getDouble(Scanner sc, String prompt) {
		double retVal = 0.0;

		boolean isValid = false;

		while (!isValid) {
			System.out.println(prompt);
			if (sc.hasNextDouble()) {
				retVal = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Invalid decimal number");
				sc.next();
			}
		}
		return retVal;
	}

	public static int getInt(Scanner sc, String prompt) {
		int retVal = 0;

		boolean isValid = false;

		while (!isValid) {
			System.out.println(prompt);
			if (sc.hasNextInt()) {
				retVal = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Invalid entry");
				sc.next();
			}

		}
		return retVal;

	}

	public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max) {
		double retVal = 0.0;
		boolean isValid = false;
		while (!isValid) {
			retVal = getDouble(sc, prompt);
			if (retVal <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (retVal >= max) {
				System.out.println("Error! Number must be greater than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return retVal;

	}

	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
		int retVal = 0;
		boolean isValid = false;
		while (!isValid) {
			retVal = getInt(sc, prompt);
			if (retVal <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (retVal >= max) {
				System.out.println("Error! Number must be greater than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return retVal;
	}
}
