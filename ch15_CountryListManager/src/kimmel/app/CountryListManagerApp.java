package kimmel.app;

import java.util.ArrayList;

public class CountryListManagerApp {

	private static void printWelcomeMessage() {
		System.out.println("Country List Manager");
		System.out.println();
		System.out.println("COMMAND MENU");
		System.out.println("1- List Countries");
		System.out.println("2- Add a Country");
		System.out.println("3- Exit\n");
	}

	public static void main(String[] args) {

		printWelcomeMessage();

		CountryIO countriesIO = new CountryIO();

		int command = 0;
		while (command != 3) {
			command = Console.getInt("Enter menu number: ");
			System.out.println();

			if (command == 1) {
				ArrayList<String> countries = countriesIO.getCountries();
				for (String country : countries) {
					System.out.println(country);
				}

			} else if (command == 2) {
				String newCountry = Console.getString("Enter country: ");
				ArrayList<String> countries = countriesIO.getCountries();
				countries.add(newCountry);
				if (countriesIO.saveCountries(countries)) {
					System.out.println("This country has been saved. ");
				} else {
					System.out.println("Error saving country");
				}
			} else if (command == 3) {
				System.out.println("Bye now:)");
			} else {
				System.out.println("Input error");
			}
		}
	}

}
