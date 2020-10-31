package kimmel.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kimmel.business.Conversion;

public class LengthConverterApp {

	public static void main(String[] args) {

		List<Conversion> conversions = new ArrayList<>();
		conversions.add(new Conversion("Miles", 0.0, "Kilometers", 1.6093));
		conversions.add(new Conversion("Kilometers", 0.0, "Miles", 0.6214));
		conversions.add(new Conversion("Inches", 0.0, "Centimeters", 2.54));

		System.out.println("Length Converter");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			int action = getUserAction();

			switch (action) {

			case 1:
				doConversions(conversions);
				break;

			case 2:
				addConversion(conversions);
				break;

			case 3:
				deleteConversion(conversions);
				break;

			}

			choice = Console.getString2("Continue ? (y/n)", "y", "n");

		}

	}

	private static int getUserAction() {
		System.out.println("1 - Convert a length");
		System.out.println("2 - Add conversion");
		System.out.println("3 - Delete conversion");
		System.out.println("4 - Exit");
		return Console.getInt("Enter menu number: ");
	}

	private static void doConversions(List<Conversion> conversions) {
		// print all conversions with 1-based numbers

		int counter = 1;
		for (Conversion conversion : conversions) {
			System.out.println(counter + " - " + conversion);
			counter++;
		}
		// prompt user for conversion number
		int conversionNum = Console.getInt("Enter conversion number: ");

		// ensure user entry is valid
		if (conversionNum < 1 || conversionNum > conversions.size()) {
			System.out.println("Invalid conversion number");
			return;
		}
		// decrement conversionNum to make it zero-based
		conversionNum--;

		Conversion con = conversions.get(conversionNum);

		// prompt for the fromValue using the fromUnit in the prompt
		double fromValue = Console.getDouble("Enter " + con.getFromUnit() + ": ");

		// set the fromValue into chosen conversion

		con.setFromValue(fromValue);

		// display the result E.g. 10.0 Kilometers = 6.124 Miles

		System.out.println(
				con.getFromValue() + " " + con.getFromUnit() + " =  " + con.getToValue() + " " + con.getToUnit());

	}

	private static void addConversion(List<Conversion> conversions) {
		String getFrom = Console.getString("Enter 'From' unit: ");
		String getTo = Console.getString("Enter 'To' unit: ");
		Double conRatio = Console.getDouble("Enter the conversion ratio: ");

		if (conversions.add(new Conversion(getFrom, 0.0, getTo, conRatio))) {
			System.out.println("This entry has been saved");
		} else {
			System.out.println("Error adding new conversion");
		}

	}

	private static void deleteConversion(List<Conversion> conversions) {

		int counter = 1;
		for (Conversion conversion : conversions) {
			System.out.println(counter + " - " + conversion);
			counter++;
		}

		int toDelete = Console.getInt("Enter conversion number to delete: ");

		if (toDelete < 1 || toDelete > conversions.size()) {
			System.out.println("Invalid conversion number");
			return;
		}
		Conversion conToDelete = conversions.remove(toDelete - 1);

		System.out.println("Conversion " + toDelete + conToDelete + " has been deleted");
	}
}
