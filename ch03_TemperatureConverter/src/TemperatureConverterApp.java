import java.text.NumberFormat;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Temperature Converter");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			System.out.print("Enter degrees in Fahrenheit: ");
			double degreeFahrenheit = sc.nextDouble();

			double degreeCelsius = (degreeFahrenheit - 32) * 5 / 9;

			NumberFormat number = NumberFormat.getNumberInstance();
			number.setMaximumFractionDigits(2);

			System.out.println("Degrees in Celsius: " + number.format(degreeCelsius));

			System.out.println("Continue");

			choice = sc.next();

		}

		System.out.println("bye:)");
	}

}
