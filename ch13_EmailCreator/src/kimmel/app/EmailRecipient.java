package kimmel.app;

public class EmailRecipient {

	// fields
	private String firstName;
	private String lastName;
	private String emailAddress;

	// default constructors
	public EmailRecipient() {
		firstName = "";
		lastName = "";
		emailAddress = "";
	}

	// constructors
	public EmailRecipient(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
	}

	// getters and setters

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}

}
