
public class Grade {

	// fields
	private int numberGrade;

	// constructors
	public Grade() {
		numberGrade = 0;
	}

	public Grade(int numberGrade) {
		this.numberGrade = numberGrade;
	}

	// get and set
	public int getNumberGrade() {
		return this.numberGrade;
	}

	public void setNumberGrade(int numberGrade) {
		this.numberGrade = numberGrade;
	}

	// helper method to get letter grade
	public String getLetter() {

		if (this.getNumberGrade() >= 88) {
			return "A";
		} else if (this.getNumberGrade() >= 80) {
			return "B";
		}

		else if (this.getNumberGrade() >= 67) {
			return "C";
		}

		else if (this.getNumberGrade() >= 60) {
			return "D";
		}

		else {
			return "F";

		}

	}
}
