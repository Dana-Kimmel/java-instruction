package kimmel.app;

public class Die {

	// fields
	private int die;

	// constructors
	public Die() {
		die = 0;
	}

	public Die(int die) {
		this.die = die;
	}

	// getter
	public int getValue() {
		return die;
	}

	// helper method to roll die
	public void roll() {
		die = (int) (Math.random() * 6) + 1;

	}

}
