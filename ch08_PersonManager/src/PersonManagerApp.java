
public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager\n");

		String choice = "y";
		Customer customer = null;
		Employee employee = null;

		while (choice.equalsIgnoreCase("y")) {

			choice = Console.getString("Create customer or employee? (c/e): ", "c", "e");
			if (choice.trim().isEmpty()) {
				System.out.println("Error! This entry is required. Try again.");
			} else if (!choice.equalsIgnoreCase("c") && !choice.equalsIgnoreCase("e")) {
				System.out.println("Error! Entry must be 'c' or 'e'. Try again.");
				continue;
			} else if (choice.equalsIgnoreCase("c")) {
				customer = customerInput();
				System.out.println(customer.toString());
			} else if (choice.equalsIgnoreCase("e")) {
				employee = employeeInput();
				System.out.println(employee.toString());
			}
			choice = Console.getString("Continue? (y/n): ", "y", "n");
		}
	}

	public static Customer customerInput() {
		String first = Console.getString("\nFirst name: ");
		String last = Console.getString("Last name: ");
		String number = Console.getString("Customer number: ");
		Customer customer = new Customer(first, last, number);
		System.out.println("You entered in a new customer: ");
		return customer;
	}

	public static Employee employeeInput() {
		String first = Console.getString("\nFirst name: ");
		String last = Console.getString("Last name: ");
		String ssn = Console.getString("SSN number: ");
		Employee employee = new Employee(first, last, ssn);
		System.out.println("You entered in a new employee: ");
		return employee;
	}
}