
//import java.text.NumberFormat;
import java.math.BigDecimal;
import java.util.Scanner;

public class MPGApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Miles Per Gallon calculator");
		System.out.println(); // print a blank line

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter miles driven: ");
			BigDecimal miles = new BigDecimal(sc.next());
			// double miles = sc.nextDouble();

			System.out.print("Enter gallons of gas used: ");
			BigDecimal gallons = new BigDecimal(sc.next());
			// double gallons = sc.nextDouble();

			BigDecimal mpg = miles.divide(gallons, 2, BigDecimal.ROUND_HALF_UP);
			System.out.println("Miles per gallon is " + mpg + ".");

			System.out.println();

			// double mpg = miles / gallons;

			// Math class for rounding-Whole number- explicit cast
			// int mpgInt = (int) mpg;
			// mpg = (double) Math.round(mpg * 100) / 100;
			// System.out.println("Miles per gallon is " + mpgInt + ".");
			// System.out.println();

			// Math class for rounding-two decimal places
			// mpg = (double) Math.round(mpg * 100) / 100;
			// System.out.println("Miles per gallon is " + mpg + ".");
			// System.out.println();

			// NumberFormat class for rounding
			// NumberFormat formatter = NumberFormat.getInstance()
			// String message = formatter.format(mpg);
			// System.out.println("Miles per gallon is " + message + ".");
			// System.out.println();

			// NumberFormat class for rounding-two decimal places
			// NumberFormat formatter = NumberFormat.getInstance();
			// formatter.setMaximumFractionDigits(2);
			// String message = formatter.format(mpg);
			// System.out.println("Miles per gallon is " + message + ".");
			// System.out.println();

			System.out.print("Calculate another MPG? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}

}
