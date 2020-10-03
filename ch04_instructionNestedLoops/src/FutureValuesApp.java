import java.text.NumberFormat;

public class FutureValuesApp {

	public static void main(String[] args) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(1);

		int monthlyInvestment = 100;
		System.out.println("Monthly investment: + currency.format(monthlyInvestment" + "\n");

		String table = "";
		String headerRow = "Year      ";

		for (double rate = 5.0; rate < 7.0; rate += 0.5) {
			headerRow += percent.format(rate / 100) + "            ";

		}
		table += headerRow + "/n";

		for (int year = 1; year < 7; year++) {

			String row = year + "   ";

			for (double rate = 5.0; rate < 7.0; rate += 0.5) {
				int months = year * 12;
				double monthlyInterestRate = rate / 12 / 100;

				double futureValue = 0.0;
				for (int i = 1; i <= months; i++) {

					futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);

				}

				row += currency.format(futureValue) + "  ";
				table += row + "\n";
			}

			System.out.println(table);
		}

	}

}
