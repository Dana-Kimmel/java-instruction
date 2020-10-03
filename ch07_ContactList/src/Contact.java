
public class Contact {

	// fields
	private String firstName;
	private String lastName;
	private String contactEmail;
	private String phoneNumber;

	// constructors
	public Contact() {
		this("", "", "", "");

		// firstName = "";
		// lastName = "";
		// contactEmail = "";
		// phoneNumber = "";
	}

	public Contact(String firstName, String lastName, String contactEmail, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactEmail = contactEmail;
		this.phoneNumber = phoneNumber;
	}

	// setters and getters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// helper methods
	public String displayContact() {
		String contactInfo = "\n--------------------------------------------"
				+ "\n---- Current Contact -----------------------" + "\n--------------------------------------------"
				+ "\nName:           " + this.getFirstName() + " " + this.getLastName() + "\nEmail Address:  "
				+ this.getContactEmail() + "\nPhone Number:   " + this.getPhoneNumber()
				+ "\n--------------------------------------------";
		return contactInfo;
	}

}
