
public class Customer extends Person {

	private String number;

	public Customer() {
		number = "";
	}

	public Customer(String first, String last, String number) {
		super(first, last);
		this.number = number;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return super.toString() + "\nCustomer Number:  " + this.number;
	}

}
