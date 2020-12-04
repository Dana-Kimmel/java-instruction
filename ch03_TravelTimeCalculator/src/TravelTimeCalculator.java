import java.util.Scanner;

public class TravelTimeCalculator {

	public static void main(String[] args) {

		System.out.println("Welcome to the Travel Time Calculator");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			System.out.print("Enter miles: ");
			double miles = sc.nextDouble();

			System.out.print("Enter miles per hour: ");
			double mph = sc.nextDouble();

			int hours = (int) ((int) miles / mph);
			int min = (int) (((miles / mph) * 60) % 60);

			System.out.println("Estimated travel time: ");
			System.out.println("---------------------");
			System.out.println("Hours: " + hours);
			System.out.println("Minutes " + min);

			System.out.println("Continue (y/n): ");
			choice = sc.next();
			sc.close();

		}
		System.out.println("Goodbye:)");
	}

}
