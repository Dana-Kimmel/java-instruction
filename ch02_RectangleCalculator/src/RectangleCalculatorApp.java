import java.util.Scanner;

public class RectangleCalculatorApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Area and Perimeter Calculator");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			System.out.print("Enter length: ");
			double length = sc.nextDouble();

			System.out.println("Enter width: ");
			double width = sc.nextDouble();

			double area = width * length;
			double perimeter = (2 * width) + (2 * length);

			System.out.println("Area: " + area + "\n" + "Perimeter: " + perimeter);

			System.out.print("Continue? (y/n)");
			choice = sc.next();

			System.out.println("Bye now:)");
		}

	}

}
