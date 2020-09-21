
public class ContactListApp {

	public static void main(String args[]) {
		// display a welcome message
		System.out.println("Welcome to the Contact List application\n");

		// declare variables
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {

			// get input from the users
			String firstName = Console.getString("Enter first name: ");
			String lastName = Console.getString("Enter last name: ");
			String contactEmail = Console.getString("Enter email: ");
			String phoneNumber = Console.getString("Enter Phone: ");

			// display output (using helper method from Contact class)
			Contact contactInfo = new Contact(firstName, lastName, contactEmail, phoneNumber);
			System.out.println(contactInfo.displayContact());

			// see if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			System.out.println();

		}

	}
}
