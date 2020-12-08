package kimmel.app;

public class FactorialCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Factorial Calculator");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// prompt the user for an integer
			int number = Console.getInt("Enter an integer that's greater than 0 and less than 10: ");

			// Declare factorial variable
			long factorial = 1;

			// for loop to calculate results
			for (int i = 1; i <= number; i++) {
				factorial = factorial * i;
			}
			System.out.println("The factorial of " + number + " is " + factorial);
			// see if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			System.out.println();

		}
		System.out.println("Bye now:)");
	}
}
