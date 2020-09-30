
public class SavingsAccount extends Account {

	// fields
	private double monthlyInterestRate;
	private double calculatedInterest;

	// constructors
	public SavingsAccount() {
		monthlyInterestRate = 0.0;
		calculatedInterest = 0.0;
	}

	public SavingsAccount(double initialBalance, double monthlyInterestRate) {
		super(initialBalance);
		this.monthlyInterestRate = monthlyInterestRate;
		this.calculatedInterest = 0.0;
	}

	// getters
	public double getMonthlyIntersetRate() {
		return monthlyInterestRate;
	}

	public double getCalculatedInterest() {
		return calculatedInterest;
	}

//helpers
	public void applyMonthlyInterestRate() {
		calculatedInterest = balance * monthlyInterestRate / 100.0;
		balance += calculatedInterest;
	}
}
