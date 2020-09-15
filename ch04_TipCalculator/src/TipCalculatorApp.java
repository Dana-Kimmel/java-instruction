import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {

		// create Scanner object
		Scanner sc = new Scanner(System.in);

		// Variable declaration
		String choice = "y";
		BigDecimal percent15 = new BigDecimal(Double.toString(.15));
		BigDecimal percent20 = new BigDecimal(Double.toString(.20));
		BigDecimal percent25 = new BigDecimal(Double.toString(.25));

		// NumberFormat declaration
		NumberFormat currency = NumberFormat.getCurrencyInstance();

		// Output welcome message

		System.out.println("Tip Calculator");
		System.out.println();

		while (choice.equalsIgnoreCase("y")) {
			// prompt user input
			System.out.print("Cost of meal: ");
			BigDecimal mealCost = sc.nextBigDecimal();

			// Calculate results
			BigDecimal tip = mealCost.multiply(percent15).setScale(2, RoundingMode.HALF_UP);
			BigDecimal total = mealCost.add(tip).setScale(2, RoundingMode.HALF_UP);
			System.out.println("15%");
			System.out.println("Tip amount: " + currency.format(tip));
			System.out.println("Total amount: " + currency.format(total));

			tip = mealCost.multiply(percent20).setScale(2, RoundingMode.HALF_UP);
			total = mealCost.add(tip).setScale(2, RoundingMode.HALF_UP);
			System.out.println("20%");
			System.out.println("Tip amount: " + currency.format(tip));
			System.out.println("Total amount: " + currency.format(total));

			tip = mealCost.multiply(percent25).setScale(2, RoundingMode.HALF_UP);
			total = mealCost.add(tip).setScale(2, RoundingMode.HALF_UP);
			System.out.println("25%");
			System.out.println("Tip amount: " + currency.format(tip));
			System.out.println("Total amount: " + currency.format(total));

			System.out.println("Continue (y/n): ");
			choice = sc.next();

		}

		System.out.println("Bye now;)");
	}

}
