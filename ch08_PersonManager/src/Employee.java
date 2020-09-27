
public class Employee extends Person {

	private String ssn;

	public Employee() {
		ssn = "";
	}

	public Employee(String first, String last, String ssn) {
		super(first, last);
		this.ssn = ssn;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		String maskedSsn = "xxx-xxx-" + ssn.substring(ssn.length() - 4);
		return super.toString() + "\nSSN: " + maskedSsn;

	}
}