package kimmel.app;

public class TableOfPowersApp {

	public static void main(String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Squares and Cubes table");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// prompt the user for an integer
			int number = Console.getInt("Enter an integer: ");

			// output message
			System.out.println("\nNumber   Squared  Cubed");
			System.out.println("======   =======  =====");

			// for loop to calculate results and print out
			for (int i = 1; i <= number; i++) {
				System.out.println(i + "\t " + (i * i) + "\t  " + (i * i * i));
			}

			// see if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			System.out.println();
		}
		System.out.println("Bye now :)");
	}

}
