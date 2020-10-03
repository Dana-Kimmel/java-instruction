package yourLastName.account;
public class CheckingAccount extends Account {

	// fields
	private double monthlyFee;

	// constructors
	public CheckingAccount() {
		monthlyFee = 0.0;
	}

	public CheckingAccount(double initialBalance, double monthlyFee) {
		super(initialBalance);
		this.monthlyFee = monthlyFee;
	}

	// getters
	public double getMonthlyFee() {
		return monthlyFee;
	}

//helpers
	public void applyMonthlyFee() {
		balance -= monthlyFee;
	}

}