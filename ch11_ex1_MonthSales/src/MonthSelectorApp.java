import java.text.NumberFormat;

public class MonthSelectorApp {

	public static void main(String[] args) {
		System.out.println("Monthly Sales\n");

		// declare monthNames and monthSales arrays
		String[] monthNames = new String[12];
		monthNames[0] = "January";
		monthNames[1] = "February";
		monthNames[2] = "March";
		monthNames[3] = "April";
		monthNames[4] = "May";
		monthNames[5] = "June";
		monthNames[6] = "July";
		monthNames[7] = "August";
		monthNames[8] = "September";
		monthNames[9] = "October";
		monthNames[10] = "November";
		monthNames[11] = "December";

		double[] monthSales = { 1000.0, 1250.0, 1200.0, 1100.0, 1255.0, 1300.0, 1175.0, 1325.0, 1200.0, 1100.0, 1300.0,
				1400.0 };

		// get currency formatting
		NumberFormat currency = NumberFormat.getCurrencyInstance();

		// get one or more months
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			int monthNumber = Console.getInt("Enter month number: ");
			// adjusts user input -1 as in Jan = 1 now instead of the array value of 0
			monthNumber--;
			// validate input
			if (monthNumber < 0 || monthNumber > monthNames.length) {
				Console.displayLine("Invalid month number. Try again.");
				continue;
			}

			// get the index number for the month
			// and display the month name and sales

			System.out.println("Sales for " + monthNames[monthNumber] + currency.format(monthSales[monthNumber]));
			// check if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			Console.displayLine();
		}

		// display the total sales for the year
		// double totalSales = 0.0;
		// for (int i = 0; i < monthSales.length; i++) {
		// totalSales += monthSales[i];
		// }

		double totalSale = 0.0;
		for (double totalSales : monthSales) {
			totalSale += totalSales;
		}
		System.out.println("Total sales: " + currency.format(totalSale));
		Console.displayLine();
	}

}
